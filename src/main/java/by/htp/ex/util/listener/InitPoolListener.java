package by.htp.ex.util.listener;

import by.htp.ex.dao.cpool.ConnectionPool;
import by.htp.ex.dao.cpool.ConnectionPoolException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class InitPoolListener implements ServletContextListener{
	
	public static ConnectionPool connectionPool = new ConnectionPool();
	
	public void contextInitialized(ServletContextEvent event) {
		
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		
		try {
			connectionPool.dispose();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionPool getConnectionPool() {
		return connectionPool;
	}

}
