package by.htp.ex.service.validation;

import by.htp.ex.service.ServiceException;

public class ValidationException extends ServiceException{
	
	public ValidationException(){
        super();
    }

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(Exception e){
        super(e);
    }

    public ValidationException(String message, Exception e){
        super(message, e);
    }

}
