/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.metro.client;

/**
 *
 * @author endy
 */
public class DemoCekSaldo {
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            aplikasi.banking.ws.metro.BankingWSMetro_Service service = new aplikasi.banking.ws.metro.BankingWSMetro_Service();
            aplikasi.banking.ws.metro.BankingWSMetro port = service.getBankingWSMetroPort();
            // TODO initialize WS operation arguments here
            java.lang.String nomer = "6789";
            // TODO process result here
            java.math.BigDecimal result = port.saldo(nomer);
            System.out.println("Saldo saat ini = "+result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
