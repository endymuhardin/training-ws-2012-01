package aplikasi.banking.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Rekening {
	private String nomer;
	private String nama;
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
