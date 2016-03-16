package converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import repositories.ServiceRepository;
import domain.Service;
@Component
@Transactional
public class StringToServiceConverter implements Converter<String, Service> {

	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public Service convert(String text) {
		Service result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = serviceRepository.findOne(id);
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
