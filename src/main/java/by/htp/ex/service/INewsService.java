package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface INewsService {
  void saveNews(News news) throws ServiceException;
  void deleteNews(String[] idNewses) throws ServiceException;
  void updateNews(News news) throws ServiceException;
  
  List<News> latestList(int count)  throws ServiceException;
  List<News> list()  throws ServiceException;
  News findById(int id) throws ServiceException;
}
