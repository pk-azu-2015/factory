package pl.edu.pk.azu.magazyn.exceptions;

public class NoItemFoundExceptionBean {
    private String message;

    public NoItemFoundExceptionBean() {
    }

    public NoItemFoundExceptionBean(String message) {
        this.message = NoItemFound.NO_ITEM +  message + NoItemFound.IN_WAREHOUSE;
    }

    public String getMessage() {
        return message;
    }
}
