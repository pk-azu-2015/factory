package pl.edu.pk.azu.magazyn.exceptions;


import javax.xml.ws.WebFault;

@WebFault(name = "NoItemFound")
public class NoItemFound extends Exception {
    private NoItemFoundExceptionBean exceptionBean;

    public static final String NO_ITEM = "Brak danego przedmiotu: ";
    public static final String IN_WAREHOUSE = " na stanie magazynu";


    public NoItemFound(String message, NoItemFoundExceptionBean exceptionBean) {
        super(NO_ITEM + message + IN_WAREHOUSE);
        this.exceptionBean = exceptionBean;
    }

    public NoItemFound(String message, Throwable cause, NoItemFoundExceptionBean exceptionBean) {
        super(NO_ITEM + message + IN_WAREHOUSE, cause);
        this.exceptionBean = exceptionBean;
    }

}
