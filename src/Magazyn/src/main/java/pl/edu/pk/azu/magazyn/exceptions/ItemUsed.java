package pl.edu.pk.azu.magazyn.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "ItemUsed")
public class ItemUsed extends Exception {
    private ItemUsedExceptionBean execptionBean;

    public static final String FORM = "Forma ";
    public static final String USED = " została złużyta. Weź następną formę.";

    public ItemUsed(String message, ItemUsedExceptionBean execptionBean) {
        super(FORM + message + USED);
        this.execptionBean = execptionBean;
    }

    public ItemUsed(String message, Throwable cause, ItemUsedExceptionBean execptionBean) {
        super(FORM + message + USED, cause);
        this.execptionBean = execptionBean;
    }

}
