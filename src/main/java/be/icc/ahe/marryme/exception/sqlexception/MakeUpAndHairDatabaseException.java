package be.icc.ahe.marryme.exception.sqlexception;

public class MakeUpAndHairDatabaseException extends Exception {

    public MakeUpAndHairDatabaseException () {

    }

    public MakeUpAndHairDatabaseException (String message) {
        super (message);
    }

    public MakeUpAndHairDatabaseException (Throwable cause) {
        super (cause);
    }

    public MakeUpAndHairDatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
