package aplikasi.banking.service;

import aplikasi.banking.domain.NomerRekeningInvalidException;
import java.math.BigDecimal;

import aplikasi.banking.domain.Rekening;
import aplikasi.banking.domain.RekeningDiblokirException;
import aplikasi.banking.domain.Transaksi;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        
        public List<Transaksi> daftarTransaksi(Rekening rx){
            List<Transaksi> hasil = new ArrayList<Transaksi>();
            
            Rekening r = informasiRekening(rx.getNomer());
            
            Transaksi t1 = new Transaksi();
            t1.setId(UUID.randomUUID().toString());
            t1.setRekening(r);
            t1.setNilai(new BigDecimal(100000));
            t1.setWaktu(new Date());
            t1.getDaftarKeterangan().add("Transaksi 1");
            t1.getDaftarKeterangan().add("Rekening "+r.getNomer());
            hasil.add(t1);
            
            Transaksi t2 = new Transaksi();
            t2.setId(UUID.randomUUID().toString());
            t2.setRekening(r);
            t2.setNilai(new BigDecimal(200000));
            t2.setWaktu(new Date());
            t2.getDaftarKeterangan().add("Transaksi 2");
            t2.getDaftarKeterangan().add("Rekening "+r.getNomer());
            hasil.add(t2);
            
            return hasil;
        }
}
