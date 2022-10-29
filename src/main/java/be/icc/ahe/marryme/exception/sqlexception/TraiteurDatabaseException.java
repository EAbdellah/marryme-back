package be.icc.ahe.marryme.exception.sqlexception;

public class TraiteurDatabaseException extends Exception {

    public TraiteurDatabaseException () {

    }

    public TraiteurDatabaseException (String message) {
        super (message);
    }

    public TraiteurDatabaseException (Throwable cause) {
        super (cause);
    }

    public TraiteurDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
