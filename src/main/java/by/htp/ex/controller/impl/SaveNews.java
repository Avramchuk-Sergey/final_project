package by.htp.ex.controller.impl;

import static by.htp.ex.util.constant.Parameters.*;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveNews implements Command{
	
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter(NEWS_ID));
		String title = request.getParameter(TITLE);
		String brief  = request.getParameter(BRIEF);
		String content = request.getParameter(CONTENT);
		
		News news = new News(id, title, brief, content);
		
		try {
			newsService.updateNews(news);
			response.sendRedirect("controller?command=go_to_news_list");
		}catch (ServiceException e) {
			response.sendRedirect("controller?command=go_to_error_page");
		}
		
	}

}
