package converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import repositories.FeePaymentRepository;
import domain.FeePayment;
@Component
@Transactional
public class StringToFeePaymentConverter implements Converter<String, FeePayment> {

	@Autowired
	FeePaymentRepository feepaymentRepository;

	@Override
	public FeePayment convert(String text) {
		FeePayment result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = feepaymentRepository.findOne(id);
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
