package pl.edu.pk.azu.magazyn.exceptions;



public class NoItemFound extends Exception {

    public static final String NO_ITEM = "Brak danego przedmiotu: ";
    public static final String IN_WAREHOUSE = " na stanie magazynu";


    public NoItemFound(String message) {
        super(NO_ITEM + message + IN_WAREHOUSE);
    }

    public NoItemFound(String message, Throwable cause) {
        super(NO_ITEM + message + IN_WAREHOUSE, cause);
    }

}
