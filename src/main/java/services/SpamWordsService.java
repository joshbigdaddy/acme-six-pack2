package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SpamWords;

import repositories.SpamWordsRepository;

@Service
@Transactional
public class SpamWordsService {

	@Autowired
	private SpamWordsRepository spamWordsRepository;

	// Supporting Services

	// Constructor

	public SpamWordsService() {
		super();
	}

	public SpamWords create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		SpamWords g;
		g = new SpamWords();
		return g;
	}

	public SpamWords findOne(int gId) {
		SpamWords result;

		result = spamWordsRepository.findOne(gId);

		return result;
	}

	public Collection<SpamWords> findAll() {
		return spamWordsRepository.findAll();
	}
	public SpamWords findFirst(){
		SpamWords result=null;

		for(SpamWords s: spamWordsRepository.findAll()){
			result=s;
			break;
		}

		return result;
	}

	public void save(SpamWords g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		spamWordsRepository.save(g);
	}

	public void delete(SpamWords g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);

		spamWordsRepository.delete(g);

	}

	// Other bussines methods
}