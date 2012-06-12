/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.domain;

import aplikasi.banking.service.CoreBankingService;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class JaxbAnnotationTest {
    @Test
    public void testMarshallTransaksi() throws Exception {
        JAXBContext ctx = JAXBContext.newInstance(Transaksi.class);
        StringWriter writer = new StringWriter();
        
        CoreBankingService service = new CoreBankingService();
        Transaksi t = service.daftarTransaksi(service.informasiRekening("123")).get(0);
        
        ctx.createMarshaller().marshal(t, writer);
        System.out.println(writer.toString());
    }
}
