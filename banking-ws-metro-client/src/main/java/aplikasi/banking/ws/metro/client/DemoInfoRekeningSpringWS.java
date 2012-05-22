/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.metro.client;

/**
 *
 * @author endy
 */
public class DemoInfoRekeningSpringWS {
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            com.artivisi.banking.BankingService service = new com.artivisi.banking.BankingService();
            com.artivisi.banking.Banking port = service.getBankingSoap11();
            // TODO initialize WS operation arguments here
            com.artivisi.banking.InfoRekeningRequest infoRekeningRequest = new com.artivisi.banking.InfoRekeningRequest();
            infoRekeningRequest.setNomer("123");
            // TODO process result here
            com.artivisi.banking.InfoRekeningResponse result = port.infoRekening(infoRekeningRequest);
            System.out.println("Nama Rekening = "+result.getRekening().getNama());
            System.out.println("Nomer Rekening = "+result.getRekening().getNomer());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
