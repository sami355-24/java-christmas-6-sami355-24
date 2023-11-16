package christmas.Exception;

public class CommonValidateException extends IllegalArgumentException{

    public CommonValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
