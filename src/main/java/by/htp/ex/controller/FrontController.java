package by.htp.ex.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import by.htp.ex.dao.cpool.ConnectionPool;
import by.htp.ex.util.listener.InitPoolListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String QUERY = "SELECT * FROM users";
	
	private final CommandProvider provider = new CommandProvider();
       

    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			        
	        String commandName = request.getParameter("command");

			Command command = provider.getCommand(commandName);
			command.execute(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
