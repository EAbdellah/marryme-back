package be.icc.ahe.marryme.exception.sqlexception;

public class ServiceDatabaseException extends Exception {

    public ServiceDatabaseException () {

    }

    public ServiceDatabaseException (String message) {
        super (message);
    }

    public ServiceDatabaseException (Throwable cause) {
        super (cause);
    }

    public ServiceDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
