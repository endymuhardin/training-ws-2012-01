package aplikasi.banking.service;

import java.math.BigDecimal;

import aplikasi.banking.domain.Rekening;

public class CoreBankingService {
	public Rekening informasiRekening(String nomer){
		// sementara hardcode dulu
		Rekening r = new Rekening();
		r.setNomer(nomer);
		r.setNama("Endy Muhardin");
		r.setSaldo(new BigDecimal(100000.00));
		return r;
	}
	
	public BigDecimal cekSaldo(String nomer){
		// sementara hardcode dulu
		return new BigDecimal(100000.00); 
	}
}
