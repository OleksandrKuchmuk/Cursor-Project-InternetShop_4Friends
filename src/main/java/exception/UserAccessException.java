package exception;

    // Винятки, які можна запобігти.

public class UserAccessException extends RuntimeException {

    public UserAccessException(String message) {
        super(message);
    }
}