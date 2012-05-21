/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.metro.client;

import aplikasi.banking.ws.metro.BankingWSMetro;
import aplikasi.banking.ws.metro.BankingWSMetro_Service;
import aplikasi.banking.ws.metro.Rekening;

/**
 *
 * @author endy
 */
public class DemoInfoRekening {
    public static void main(String[] args) {
        BankingWSMetro_Service service = new BankingWSMetro_Service();
        BankingWSMetro port = service.getBankingWSMetroPort();
        
        Rekening rek = port.info("12345");
        System.out.println("No Rekening : "+rek.getNomer());
        System.out.println("Nama : "+rek.getNama());
    }
}
