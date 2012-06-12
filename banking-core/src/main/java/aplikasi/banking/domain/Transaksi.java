/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author endy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Transaksi {
    private String id;
    private Rekening rekening;
    
    @XmlElementWrapper
    private List<String> daftarKeterangan = new ArrayList<String>();
    
    private Date waktu;
    private BigDecimal nilai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlTransient
    public List<String> getDaftarKeterangan() {
        return daftarKeterangan;
    }

    public void setDaftarKeterangan(List<String> daftarKeterangan) {
        this.daftarKeterangan = daftarKeterangan;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }
    
    
}
