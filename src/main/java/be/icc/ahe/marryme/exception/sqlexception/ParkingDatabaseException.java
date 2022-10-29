package be.icc.ahe.marryme.exception.sqlexception;

public class ParkingDatabaseException extends Exception {

    public ParkingDatabaseException () {

    }

    public ParkingDatabaseException (String message) {
        super (message);
    }

    public ParkingDatabaseException (Throwable cause) {
        super (cause);
    }

    public ParkingDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
