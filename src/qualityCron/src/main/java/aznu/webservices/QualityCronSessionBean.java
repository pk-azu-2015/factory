/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aznu.webservices;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author root
 */
@Stateless
public class QualityCronSessionBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/quality/QualityWebService.wsdl")
    private QualityWebService_Service service;

    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    
    public void execute() {
        try { // Call Web Service Operation
            aznu.webservices.QualityWebService port = service.getQualityWebServicePort();

            for(Norma norma : Norma.values()){
                java.lang.String result = port.sprawdzStan(norma.name());
                System.out.println("Result = "+result);
            }
        } catch (Exception ex) {
        }


    }


}
