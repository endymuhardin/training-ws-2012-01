/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.spring.dto;

import aplikasi.banking.domain.Transaksi;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author endy
 */
@XmlRootElement
public class SimpanTransaksiRequest {
    private Transaksi transaksi;

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }
}
