package be.icc.ahe.marryme.exception.sqlexception;

public class FermetureDatabaseException extends Exception {

    public FermetureDatabaseException () {

    }

    public FermetureDatabaseException (String message) {
        super (message);
    }

    public FermetureDatabaseException (Throwable cause) {
        super (cause);
    }

    public FermetureDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
