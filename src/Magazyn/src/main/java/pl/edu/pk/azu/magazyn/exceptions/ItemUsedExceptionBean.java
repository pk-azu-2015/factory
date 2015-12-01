package pl.edu.pk.azu.magazyn.exceptions;

public class ItemUsedExceptionBean {
    private String message;

    public ItemUsedExceptionBean() {
    }

    public ItemUsedExceptionBean(String message) {
        this.message = ItemUsed.FORM +  message + ItemUsed.USED;
    }

    public String getMessage() {
        return message;
    }
}
