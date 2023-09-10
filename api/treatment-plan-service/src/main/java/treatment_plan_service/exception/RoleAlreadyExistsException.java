package treatment_plan_service.exception;

public class RoleAlreadyExistsException extends Exception{
    public RoleAlreadyExistsException(){
        super("role already exists!");
    }

}
