package starter_microservice.exception;

public class CannotDeleteException extends Exception{
    public CannotDeleteException(String message) {
        super(message);
    }
}
