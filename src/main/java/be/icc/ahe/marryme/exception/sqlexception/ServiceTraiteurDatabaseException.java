package be.icc.ahe.marryme.exception.sqlexception;

public class ServiceTraiteurDatabaseException extends Exception {

    public ServiceTraiteurDatabaseException () {

    }

    public ServiceTraiteurDatabaseException (String message) {
        super (message);
    }

    public ServiceTraiteurDatabaseException (Throwable cause) {
        super (cause);
    }

    public ServiceTraiteurDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
