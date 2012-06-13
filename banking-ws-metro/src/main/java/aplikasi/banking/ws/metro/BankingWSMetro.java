/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.metro;

import aplikasi.banking.domain.Rekening;
import aplikasi.banking.service.CoreBankingService;
import java.io.*;
import java.math.BigDecimal;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author endy
 */
@MTOM
@WebService(serviceName = "BankingWSMetro")
public class BankingWSMetro {

    // nantinya ini diinject pakai @Autowired (Spring)
    // atau pakai @EJB (JEE)
    private CoreBankingService service = new CoreBankingService();
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "saldo")
    public BigDecimal cekSaldo(@WebParam(name = "nomer") String nomer) {
        // hanya wrapper saja, business logic tidak disini
        return service.cekSaldo(nomer); 
    }
    
    @WebMethod(operationName = "info")
    public Rekening informasi(@WebParam(name="nomer")String nomer){
        return service.informasiRekening(nomer);
    }
    
    @WebMethod(operationName="laporan")
    public DataHandler downloadLaporan() throws Exception {
        InputStream is = BankingWSMetro.class.getResourceAsStream("/getting-started.pdf");
        File temp = File.createTempFile("xxxxx", "xx");
        OutputStream os = new FileOutputStream(temp);
        int data;
        while((data = is.read()) != -1){
            os.write(data);
        }
        return new DataHandler(new FileDataSource(temp));
    }
}
