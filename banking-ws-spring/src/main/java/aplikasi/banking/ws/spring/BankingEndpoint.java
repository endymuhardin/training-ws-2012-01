package aplikasi.banking.ws.spring;

import aplikasi.banking.service.CoreBankingService;
import com.artivisi.banking.InfoRekeningRequest;
import com.artivisi.banking.InfoRekeningResponse;
import com.artivisi.banking.SaldoRequest;
import com.artivisi.banking.SaldoResponse;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.GregorianCalendar;
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
}
