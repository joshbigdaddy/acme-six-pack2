package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ServiceRepository;

@Service
@Transactional
public class ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	// Supporting Services

	// Constructor

	public ServiceService() {
		super();
	}

	public domain.Service create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		domain.Service m;
		m = new domain.Service();
		return m;
	}

	public domain.Service findOne(int mId) {
		domain.Service result;

		result = serviceRepository.findOne(mId);

		return result;
	}

	public Collection<domain.Service> findAll() {
		return serviceRepository.findAll();
	}

	public void save(domain.Service m) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		serviceRepository.save(m);
	}

	// Other bussines methods

	public Collection<domain.Service> mostPopular() {
		return serviceRepository.mostPopular();
	}

	public Collection<domain.Service> lessPopular() {
		return serviceRepository.lessPopular();

	}

	public Collection<domain.Service> moreCommentedGym() {
		Collection<domain.Service> result;
		result = serviceRepository.moreCommentedService();
		Assert.notNull(result);

		return result;
	}

	public Double averageCommentsPerService() {
		Double result;
		result = serviceRepository.averageCommentsPerService();
		Assert.notNull(result);

		return result;
	}

}