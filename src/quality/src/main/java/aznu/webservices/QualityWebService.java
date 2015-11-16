package aznu.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class QualityWebService {

    @WebMethod(operationName = "checkState")
    public String checkState(@WebParam(name="productName") String productName) {
        if (productName == null) {
            return "Test";
        }
        return "Product " + productName;
    }
}