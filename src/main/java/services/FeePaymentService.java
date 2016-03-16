package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.FeePayment;

import repositories.FeePaymentRepository;

@Service
@Transactional
public class FeePaymentService {

	@Autowired
	private FeePaymentRepository feePaymentRepository;

	// Supporting Services

	// Constructor

	public FeePaymentService() {
		super();
	}

	public FeePayment create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		FeePayment fp;
		fp = new FeePayment();
		return fp;
	}

	public FeePayment findOne(int fpId) {
		FeePayment result;

		result = feePaymentRepository.findOne(fpId);

		return result;
	}

	public Collection<FeePayment> findAll() {
		return feePaymentRepository.findAll();
	}

	public void save(FeePayment fp) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		feePaymentRepository.save(fp);
	}

	public void delete(FeePayment fp) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);

		feePaymentRepository.delete(fp);

	}

	// Other bussines methods
}