/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.metro;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author endy
 */
@WebService(serviceName = "BankingWSMetro")
public class BankingWSMetro {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
}
