/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.metro.client;

/**
 *
 * @author endy
 */
public class DemoCekSaldoSpringWS {
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            com.artivisi.banking.BankingService service = new com.artivisi.banking.BankingService();
            com.artivisi.banking.Banking port = service.getBankingSoap11();
            // TODO initialize WS operation arguments here
            com.artivisi.banking.SaldoRequest saldoRequest = new com.artivisi.banking.SaldoRequest();
            saldoRequest.setNomer("123");
            // TODO process result here
            com.artivisi.banking.SaldoResponse result = port.saldo(saldoRequest);
            System.out.println("Result = "+result.getSaldo());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
