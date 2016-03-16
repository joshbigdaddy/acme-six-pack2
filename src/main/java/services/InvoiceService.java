package services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Customer;
import domain.FeePayment;
import domain.Invoice;

import repositories.InvoiceRepository;

@Service
@Transactional
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	// Supporting Services
	private CustomerService customerService;
	private FeePaymentService feePaymentService;
	
	
	public InvoiceService() {
		super();
	}

	public Invoice create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		Collection<FeePayment> feePayments= new HashSet<FeePayment>();
		Invoice invoice = new Invoice();
		Customer c= customerService.findByPrincipal();
		invoice.setName(c.getName());
		for(FeePayment f: c.getFeePayments()){
			if(f.getInvoiced()==false){
				feePayments.add(f);
				f.setInvoiced(true);
				feePaymentService.save(f);
				
			}
		}
		
		return invoice;
	}

	public Invoice findOne(int gId) {
		Invoice result;

		result = invoiceRepository.findOne(gId);

		return result;
	}

	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Collection<Invoice> getMyInvoice(){
		Customer c= customerService.findByPrincipal();
		Collection<Invoice> invoices = c.getInvoices();
		return invoices;
	}

	public void save(Invoice g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		invoiceRepository.save(g);
	}

	public void delete(Invoice c) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		
		invoiceRepository.delete(c);

	}

	// Other bussines methods
}