package pl.edu.pk.azu.magazyn.exceptions;


public class NoItemFound extends Exception {
    public static final String NO_ITEM = "Brak danego przedmiotu: ";
    public static final String IN_WAREHOUSE = " na stanie magazynu";

    public NoItemFound() {
    }

    public NoItemFound(String item) {
        super(NO_ITEM + item + IN_WAREHOUSE);
    }
}
