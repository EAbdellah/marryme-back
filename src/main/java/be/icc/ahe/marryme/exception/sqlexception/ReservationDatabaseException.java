package be.icc.ahe.marryme.exception.sqlexception;

public class ReservationDatabaseException extends Exception {

    public ReservationDatabaseException () {

    }

    public ReservationDatabaseException (String message) {
        super (message);
    }

    public ReservationDatabaseException (Throwable cause) {
        super (cause);
    }

    public ReservationDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
