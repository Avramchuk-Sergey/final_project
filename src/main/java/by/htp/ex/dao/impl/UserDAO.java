package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.User;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.cpool.ConnectionPool;
import by.htp.ex.dao.cpool.ConnectionPoolException;
import by.htp.ex.util.listener.InitPoolListener;

public class UserDAO implements IUserDAO {

	private ConnectionPool connectionPool = InitPoolListener.getConnectionPool();

	private static final String GET_ROLE_QUERY = "SELECT * FROM roles WHERE id = ?";
	private static final String CLIENT_ROLES_ID = "2";
	private static final String QUOTE = "'";

	@Override
	public User logination(String email, String password) throws DaoException {

		String loginationQuery = createLoginationQuery(email, password);

		Connection connection = null;
		Statement statement = null;
		User user = null;

		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(loginationQuery);

			if (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String surname = resultSet.getString(3);
				String login = resultSet.getString(5);
				Integer roles_id = resultSet.getInt(7);
				user = new User(id, name, surname, password, login, email, getRole(roles_id));
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);

		} finally {
			if (statement != null) {
				try {
					connectionPool.closeConnection(connection, statement);
					} catch (ConnectionPoolException e) {
						throw new DaoException(e);
					}
			}
		}

		return user;
	}

	public String getRole(Integer id) throws DaoException {

		Connection connection = null;
		PreparedStatement statement = null;
		String role = "";
		try {
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(GET_ROLE_QUERY);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				role = resultSet.getString(2);
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);

		} finally {
			if (statement != null) {
				try {
					connectionPool.closeConnection(connection, statement);
					} catch (ConnectionPoolException e) {
						throw new DaoException(e);
					}
			}
		}

		return role;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException {

		String addUserQuery = createAddUserQuery(user);

		Connection connection = null;
		Statement statement = null;

		try {

			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			statement.executeUpdate(addUserQuery);

		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);

		} finally {

			if (statement != null) {
				try {
					connectionPool.closeConnection(connection, statement);
					} catch (ConnectionPoolException e) {
						throw new DaoException(e);
					}
			}
		}

		return true;
	}

	private String createLoginationQuery(String email, String password) {

		StringBuilder sb = new StringBuilder(150);
		sb.append("SELECT * FROM users WHERE email = ").append(QUOTE).append(email).append(QUOTE)
				.append(" AND password = ").append(QUOTE).append(password).append(QUOTE);

		return sb.toString();
	}

	private String createAddUserQuery(NewUserInfo user) {
		String name = user.getFirstName();
		String surname = user.getSurname();
		String password = user.getPassword();
		String login = user.getLogin();
		String email = user.getEmail();

		String addUserQuery = "INSERT INTO users (name, surname, password, login, email, roles_id ) " + "VALUES (" + "'"
				+ name + "', " + "'" + surname + "', " + "'" + password + "', " + "'" + login + "', " + "'" + email
				+ "', " + "'" + CLIENT_ROLES_ID + "')";
		return addUserQuery;
	}

}
