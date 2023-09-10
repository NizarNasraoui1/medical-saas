package starter_microservice.exception;

public class AuthorityAlreadyExists extends Exception{
    public AuthorityAlreadyExists(){
        super("authority already exists");
    }
}
