package aznu.webservices;

import aznu.webservices.client.Magazyn;
import aznu.webservices.client.Magazyn_Service;
import aznu.webservices.client.Stan;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class QualityWebService {

    private Magazyn_Service magazyn_service = new Magazyn_Service();

    @WebMethod(operationName = "checkState")
    public String checkState() {
        Magazyn magazynPort = magazyn_service.getMagazynPort();
        return "";
    }
}