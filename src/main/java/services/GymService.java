package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Gym;

import repositories.GymRepository;

@Service
@Transactional
public class GymService {

	@Autowired
	private GymRepository gymRepository;

	// Supporting Services

	// Constructor

	public GymService() {
		super();
	}

	public Gym create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		Gym g;
		g = new Gym();
		return g;
	}

	public Gym findOne(int gId) {
		Gym result;

		result = gymRepository.findOne(gId);

		return result;
	}

	public Collection<Gym> findAll() {
		return gymRepository.findAll();
	}

	public void save(Gym g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		gymRepository.save(g);
	}

	public void delete(Gym g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);

		gymRepository.delete(g);

	}

	// Other bussines methods
	public Collection<Gym> mostPopular() {
		return gymRepository.mostPopular();
	}

	public Collection<Gym> lessPopular() {
		return gymRepository.lessPopular();
	}

	public String devuelveGoogleMaps(Gym g) {
		String calle = g.getPostalAddress();
		String link = "https://www.google.es/maps/place/";
		String parte = calle.replaceAll(" ", "+");
		return link + parte;
	}

	public Collection<Gym> moreCommentedGym() {
		Collection<Gym> result;
		result = gymRepository.moreCommentedGym();
		Assert.notNull(result);

		return result;
	}

	public Double averageCommentsPerGym() {
		Double result;
		result = gymRepository.averageCommentsPerGym();
		Assert.notNull(result);

		return result;
	}

}