package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Curriculum;

import repositories.CurriculumRepository;

@Service
@Transactional
public class CurriculumService {

	@Autowired
	private CurriculumRepository curriculumRepository;

	// Supporting Services

	// Constructor

	public CurriculumService() {
		super();
	}

	public Curriculum create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		Curriculum fp;
		fp = new Curriculum();
		return fp;
	}

	public Curriculum findOne(int fpId) {
		Curriculum result;

		result = curriculumRepository.findOne(fpId);

		return result;
	}

	public Collection<Curriculum> findAll() {
		return curriculumRepository.findAll();
	}

	public void save(Curriculum fp) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		curriculumRepository.save(fp);
	}

	public void delete(Curriculum fp) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);

		curriculumRepository.delete(fp);

	}

	// Other bussines methods
}