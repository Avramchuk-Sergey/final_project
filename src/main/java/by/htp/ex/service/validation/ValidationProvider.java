package by.htp.ex.service.validation;

public class ValidationProvider {
	
	private static final ValidationProvider instance = new ValidationProvider();
	private final UserDataValidation userValidator = new UserDataValidationImpl();
	private final NewsValidation newsValidator = new NewsValidationImpl();
	
	private ValidationProvider() {
		
	}

	public static ValidationProvider getInstance() {
		return instance;
	}
	
	public UserDataValidation getUserDataValidator() {
		return userValidator;
	}
	
	public NewsValidation getNewsValidator() {
		return newsValidator;
	}
}
