package by.htp.ex.dao.cpool;

import jakarta.servlet.ServletException;

public class ConnectionPoolException extends ServletException {
	
	 private static final long serialVersionUID = 1L;

	 public ConnectionPoolException(){
	        super();
	    }

	    public ConnectionPoolException(String message){
	        super(message);
	    }

	    public ConnectionPoolException(Exception e){
	        super(e);
	    }

	    public ConnectionPoolException(String message, Exception e){
	        super(message, e);
	    }

}
