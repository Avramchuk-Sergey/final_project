package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.User;

public interface IUserDAO {
	
	User logination(String login, String password) throws DaoException;
	boolean registration(NewUserInfo user) throws DaoException;
	public String getRole(Integer id) throws DaoException;

}
