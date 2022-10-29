package be.icc.ahe.marryme.exception.sqlexception;

public class PersonDatabaseException extends Exception {

    public PersonDatabaseException () {

    }

    public PersonDatabaseException (String message) {
        super (message);
    }

    public PersonDatabaseException (Throwable cause) {
        super (cause);
    }

    public PersonDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
