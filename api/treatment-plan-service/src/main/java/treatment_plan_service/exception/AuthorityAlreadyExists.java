package treatment_plan_service.exception;

public class AuthorityAlreadyExists extends Exception{
    public AuthorityAlreadyExists(){
        super("authority already exists");
    }
}
