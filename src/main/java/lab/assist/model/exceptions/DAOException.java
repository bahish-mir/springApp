package lab.assist.model.exceptions;

public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String userNotFoundMessage) {
    }
}
