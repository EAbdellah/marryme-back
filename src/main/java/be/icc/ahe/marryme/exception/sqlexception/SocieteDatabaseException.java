package be.icc.ahe.marryme.exception.sqlexception;

public class SocieteDatabaseException  extends Exception {

    public SocieteDatabaseException () {

    }

    public SocieteDatabaseException (String message) {
        super (message);
    }

    public SocieteDatabaseException (Throwable cause) {
        super (cause);
    }

    public SocieteDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
