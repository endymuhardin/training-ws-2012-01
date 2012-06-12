/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.ws.spring.dto;

import aplikasi.banking.domain.Transaksi;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author endy
 */
@XmlSeeAlso(Transaksi.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class DaftarTransaksiResponse {
    
    @XmlElementWrapper @XmlAnyElement
    private List<Transaksi> daftarTransaksi = new ArrayList<Transaksi>();

    public List<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    public void setDaftarTransaksi(List<Transaksi> daftarTransaksi) {
        this.daftarTransaksi = daftarTransaksi;
    }
    
}
