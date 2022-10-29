package be.icc.ahe.marryme.exception.sqlexception;

public class FormuleDatabaseException extends Exception {

    public FormuleDatabaseException () {

    }

    public FormuleDatabaseException (String message) {
        super (message);
    }

    public FormuleDatabaseException (Throwable cause) {
        super (cause);
    }

    public FormuleDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
