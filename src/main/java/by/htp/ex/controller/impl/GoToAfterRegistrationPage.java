package by.htp.ex.controller.impl;

import static by.htp.ex.util.constant.JspPages.AFTER_REGISTRATION_JSP;
import static by.htp.ex.util.constant.Parameters.URL;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAfterRegistrationPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(AFTER_REGISTRATION_JSP).forward(request, response);
		
	}

}
