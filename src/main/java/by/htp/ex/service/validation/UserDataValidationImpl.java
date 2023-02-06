package by.htp.ex.service.validation;

import static by.htp.ex.util.constant.ExpressionPatterns.*;

import by.htp.ex.bean.NewUserInfo;

public class UserDataValidationImpl implements UserDataValidation{
	
	
	
	private static final int MIN_PASSWORD_SIZE = 10;
    
	@Override
	public boolean checkUserData(String email, String password) throws ValidationException{
		
		if(!(validateEmail(email) && validatePassword(password))) {
			throw new ValidationException();
		}
		
		return true;
	}
	
	
	private boolean validateEmail(String email){

	       return email.matches(EMAIL_ADDRESS);
	    }

    private boolean validatePassword(String password){

	        return password.matches(VALID_PASSWORD) & password.length()>= MIN_PASSWORD_SIZE;
	    }
}
