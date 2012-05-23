package aplikasi.banking.service;

import aplikasi.banking.domain.NomerRekeningInvalidException;
import java.math.BigDecimal;

import aplikasi.banking.domain.Rekening;
import aplikasi.banking.domain.RekeningDiblokirException;
import java.util.Date;

public class CoreBankingService {
	public Rekening informasiRekening(String nomer){
		// sementara hardcode dulu
		Rekening r = new Rekening();
		r.setNomer(nomer);
		r.setNama("Endy Muhardin");
		r.setSaldo(new BigDecimal(100000.00));
                r.setTanggalPembukaan(new Date());
		return r;
	}
	
	public BigDecimal cekSaldo(String nomer){
            if(nomer == null || nomer.length() < 3){
                throw new NomerRekeningInvalidException("Format nomer rekening salah");
            }
            
            if("456".equals(nomer)) {
                    throw new RekeningDiblokirException("Rekening "+nomer+" saat ini tidak bisa digunakan");
                }

            // sementara hardcode dulu
		return new BigDecimal(100000.00); 
	}
}
