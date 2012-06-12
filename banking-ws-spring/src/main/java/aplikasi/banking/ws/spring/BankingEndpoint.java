package aplikasi.banking.ws.spring;

import aplikasi.banking.domain.Rekening;
import aplikasi.banking.domain.Transaksi;
import aplikasi.banking.ws.spring.exception.InvalidInputException;
import aplikasi.banking.service.CoreBankingService;
import aplikasi.banking.ws.spring.dto.DaftarTransaksiResponse;
import aplikasi.banking.ws.spring.dto.SimpanTransaksiRequest;
import com.artivisi.banking.InfoRekeningRequest;
import com.artivisi.banking.InfoRekeningResponse;
import com.artivisi.banking.SaldoRequest;
import com.artivisi.banking.SaldoResponse;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.GregorianCalendar;
import org.springframework.util.StringUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BankingEndpoint {
	private CoreBankingService coreBankingService = new CoreBankingService();
	
	
	@PayloadRoot(localPart="SaldoRequest", 
			namespace="http://www.artivisi.com/banking")
	@ResponsePayload
	public SaldoResponse saldo(@RequestPayload SaldoRequest saldoRequest){
		// hanya wrapper saja, business logic tidak disini
		String nomer = saldoRequest.getNomer();
                
                // validasi nomer rekening harus diisi
                if(!StringUtils.hasText(nomer)){
                    throw new InvalidInputException("Nomer rekening harus diisi");
                }
                
		SaldoResponse response = new SaldoResponse();
		response.setSaldo(coreBankingService.cekSaldo(nomer));
		return response;
	}
        
        @PayloadRoot(localPart="InfoRekeningRequest", 
			namespace="http://www.artivisi.com/banking")
	@ResponsePayload
	public InfoRekeningResponse info(@RequestPayload InfoRekeningRequest request){
		// hanya wrapper saja, business logic tidak disini
		String nomer = request.getNomer();
		InfoRekeningResponse response = new InfoRekeningResponse();
                
                aplikasi.banking.domain.Rekening rek 
                        = coreBankingService.informasiRekening(nomer);
                
                // konversi ke object hasil generate JAXB
                com.artivisi.banking.Rekening rekJaxb = new com.artivisi.banking.Rekening();
                rekJaxb.setNama(rek.getNama());
                rekJaxb.setNomer(rek.getNomer());
                rekJaxb.setSaldo(rek.getSaldo());
                
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(rek.getTanggalPembukaan());
                rekJaxb.setTanggalPembukaan(new XMLGregorianCalendarImpl(cal));
                
                response.setRekening(rekJaxb);
                
		return response;
	}
        
        
        @PayloadRoot(localPart="SimpanTransaksiRequest", 
			namespace="http://www.artivisi.com/banking")
        public void simpanTransaksi(@RequestPayload SimpanTransaksiRequest request){
            Transaksi t = request.getTransaksi();
            System.out.println("====== Transaksi ======");
            System.out.println("ID Transaksi : "+t.getId());
            System.out.println("Waktu : "+t.getWaktu());
            System.out.println("Nilai : "+t.getNilai());
            for (String ket : t.getDaftarKeterangan()) {
                System.out.println("Keterangan : "+ket);
            }
            
            System.out.println("====== Rekening ======");
            Rekening r = t.getRekening();
            System.out.println("Nomer : "+r.getNomer());
            System.out.println("Nama : "+r.getNama());
            System.out.println("Tanggal Buka : "+r.getTanggalPembukaan());
            System.out.println("Saldo : "+r.getSaldo());
        }
        
        @PayloadRoot(localPart="DaftarTransaksiRequest", 
			namespace="http://www.artivisi.com/banking")
	@ResponsePayload
        public DaftarTransaksiResponse daftarTransaksi(){
            Rekening r = coreBankingService.informasiRekening("123");
            DaftarTransaksiResponse response = new DaftarTransaksiResponse();
            response.setDaftarTransaksi(coreBankingService.daftarTransaksi(r));
            return response;
        }
}
