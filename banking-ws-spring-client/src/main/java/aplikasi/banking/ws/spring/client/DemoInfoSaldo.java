/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.spring.client;

import com.artivisi.banking.SaldoRequest;
import com.artivisi.banking.SaldoResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 *
 * @author endy
 */
public class DemoInfoSaldo {
    public static void main(String[] args) {
        WebServiceTemplate template = new WebServiceTemplate();
        
        Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
        jaxb2.setContextPath("com.artivisi.banking");
        template.setMarshaller(jaxb2);
        template.setUnmarshaller(jaxb2);
        
        String uri = "http://localhost:8080/banking-ws-spring/bankingService/";
        template.setDefaultUri(uri);
        
        SaldoRequest request = new SaldoRequest();
        request.setNomer("123");
        
        SaldoResponse response = (SaldoResponse) template.marshalSendAndReceive(request);
        System.out.println("Saldo : "+response.getSaldo());
    }
}
