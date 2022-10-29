package be.icc.ahe.marryme.exception.sqlexception;

public class ImageDatabaseException extends Exception {

    public ImageDatabaseException () {

    }

    public ImageDatabaseException (String message) {
        super (message);
    }

    public ImageDatabaseException (Throwable cause) {
        super (cause);
    }

    public ImageDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
