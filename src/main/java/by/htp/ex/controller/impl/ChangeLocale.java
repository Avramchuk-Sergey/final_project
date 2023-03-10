package by.htp.ex.controller.impl;

import static by.htp.ex.util.constant.Parameters.*;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ChangeLocale implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newLocale = request.getParameter(LOCALE);
		
		HttpSession session = request.getSession(true);
		session.setAttribute(LOCALE, newLocale);
		
		String lastRequestUrl = (String) session.getAttribute(URL);
		response.sendRedirect(lastRequestUrl);		
		
	}

}
