package services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SocialIdentity;

import repositories.SocialIdentityRepository;

@Service
@Transactional
public class SocialIdentityService {

	@Autowired
	private SocialIdentityRepository socialIdentityRepository;

	// Supporting Services

	// Constructor

	public SocialIdentityService() {
		super();
	}

	public SocialIdentity create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		SocialIdentity s;
		s = new SocialIdentity();
		return s;
	}

	public SocialIdentity findOne(int sId) {
		SocialIdentity result;

		result = socialIdentityRepository.findOne(sId);

		return result;
	}

	public List<SocialIdentity> findAll() {
		return socialIdentityRepository.findAll();
	}

	public void save(SocialIdentity s) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		socialIdentityRepository.save(s);
	}

	public void delete(SocialIdentity s) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
        
		socialIdentityRepository.delete(s);
		

	}

	// Other bussines methods
}