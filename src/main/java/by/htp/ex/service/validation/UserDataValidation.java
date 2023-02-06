package by.htp.ex.service.validation;

public interface UserDataValidation {
       boolean checkUserData(String email, String password)throws ValidationException;
}
