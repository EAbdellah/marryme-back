package be.icc.ahe.marryme.exception.sqlexception;

public class SalleDatabaseException extends Exception {

    public SalleDatabaseException () {

    }

    public SalleDatabaseException (String message) {
        super (message);
    }

    public SalleDatabaseException (Throwable cause) {
        super (cause);
    }

    public SalleDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
