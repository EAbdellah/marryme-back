package be.icc.ahe.marryme.exception.sqlexception;

public class AddressDatabaseException extends Exception {

    public AddressDatabaseException () {

    }

    public AddressDatabaseException (String message) {
        super (message);
    }

    public AddressDatabaseException (Throwable cause) {
        super (cause);
    }

    public AddressDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
