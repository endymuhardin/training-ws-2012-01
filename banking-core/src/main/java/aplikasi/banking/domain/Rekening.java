package aplikasi.banking.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Rekening {
	private String nomer;
	private String nama;
        @XmlSchemaType(name="date")
        private Date tanggalPembukaan;
	private BigDecimal saldo;
	
	public String getNomer() {
		return nomer;
	}
	public void setNomer(String nomer) {
		this.nomer = nomer;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

    public Date getTanggalPembukaan() {
        return tanggalPembukaan;
    }

    public void setTanggalPembukaan(Date tanggalPembukaan) {
        this.tanggalPembukaan = tanggalPembukaan;
    }
}
