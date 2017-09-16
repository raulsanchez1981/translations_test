package issues.exceptions;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public class IssueServiceException extends BaseException {

    public IssueServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IssueServiceException(String message) {
        super(message);
    }
}
