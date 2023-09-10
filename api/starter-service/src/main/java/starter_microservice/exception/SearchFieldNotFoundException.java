package starter_microservice.exception;

public class SearchFieldNotFoundException extends Exception{
    public SearchFieldNotFoundException(String msg){
        super(msg);
    }
}
