package by.htp.ex.service;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.User;

public interface IUserService {
	
	User signIn(String email, String password) throws ServiceException;
	boolean registration(NewUserInfo user) throws ServiceException;

}
