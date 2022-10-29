package be.icc.ahe.marryme.exception.sqlexception;

public class UserDatabaseException extends Exception {

    public UserDatabaseException () {

    }

    public UserDatabaseException (String message) {
        super (message);
    }

    public UserDatabaseException (Throwable cause) {
        super (cause);
    }

    public UserDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
