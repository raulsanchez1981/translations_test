package issues.exceptions;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public class IssueControllerException extends BaseException {

    public IssueControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public IssueControllerException(String message) {
        super(message);
    }
}
