package pl.edu.pk.azu.magazyn.exceptions;


public class ItemUsed extends Exception {

    public static final String FORM = "Forma ";
    public static final String USED = " została złużyta. Weź następną formę.";

    public ItemUsed(String message) {
        super(FORM + message + USED);
    }

    public ItemUsed(String message, Throwable cause) {
        super(FORM + message + USED, cause);
    }

}
