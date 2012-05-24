/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.spring.client;

import com.artivisi.banking.SaldoRequest;
import com.artivisi.banking.SaldoResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 *
 * @author endy
 */
public class DemoInfoSaldo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:client-ws-ctx.xml");
        WebServiceTemplate template = ctx.getBean(WebServiceTemplate.class);
        
        SaldoRequest request = new SaldoRequest();
        request.setNomer("123");
        
        SaldoResponse response = (SaldoResponse) template.marshalSendAndReceive(request);
        System.out.println("Saldo : "+response.getSaldo());
    }
}
