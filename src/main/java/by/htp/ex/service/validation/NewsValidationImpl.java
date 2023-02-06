package by.htp.ex.service.validation;

import by.htp.ex.bean.News;

public class NewsValidationImpl implements NewsValidation{

	@Override
	public boolean checkNews(News news) {
		// some SQL injection protection
		return true;
	}

}
