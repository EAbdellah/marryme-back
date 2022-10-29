package be.icc.ahe.marryme.exception.sqlexception;

public class MusiqueDatabaseException extends Exception {

    public MusiqueDatabaseException () {

    }

    public MusiqueDatabaseException (String message) {
        super (message);
    }

    public MusiqueDatabaseException (Throwable cause) {
        super (cause);
    }

    public MusiqueDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
