package registry_service.exception;

public class LoginAlreadyExistsException extends Exception{
    public LoginAlreadyExistsException(){
        super("login already exists");
    }
}
