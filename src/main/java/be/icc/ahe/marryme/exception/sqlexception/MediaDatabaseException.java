package be.icc.ahe.marryme.exception.sqlexception;

public class MediaDatabaseException extends Exception {

    public MediaDatabaseException () {

    }

    public MediaDatabaseException (String message) {
        super (message);
    }

    public MediaDatabaseException (Throwable cause) {
        super (cause);
    }

    public MediaDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
