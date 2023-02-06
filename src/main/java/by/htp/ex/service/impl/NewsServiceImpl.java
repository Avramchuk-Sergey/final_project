package by.htp.ex.service.impl;

import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.validation.NewsValidation;
import by.htp.ex.service.validation.UserDataValidation;
import by.htp.ex.service.validation.ValidationProvider;

public class NewsServiceImpl implements INewsService{

	private final INewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();
	private final NewsValidation validator = ValidationProvider.getInstance().getNewsValidator();
	
	@Override
	public void saveNews(News news) throws ServiceException {

		if(validator.checkNews(news)) {
		try {
			 newsDAO.addNews(news);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		}
		
	}
	
	

	@Override
	public void deleteNews(String[] idNewses) throws ServiceException {

		try {
			newsDAO.deleteNewses(idNewses);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	

	@Override
	public void updateNews(News news) throws ServiceException{
		
		try {
			 newsDAO.updateNews(news);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}
	
	

	@Override
	public List<News> latestList(int count) throws ServiceException {
		
		try {
			return newsDAO.getLatestsList(count);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	
	
	@Override
	public List<News> list() throws ServiceException {
		try {
			return newsDAO.getList();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	

	@Override
	public News findById(int id) throws ServiceException {
		try {
			return newsDAO.fetchById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
