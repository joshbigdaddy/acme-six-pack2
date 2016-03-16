package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.TrainerRepository;
import security.LoginService;
import security.UserAccount;
import domain.Trainer;

@Service
@Transactional
public class TrainerService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private TrainerRepository trainerRepository;

	
	public Trainer create() {
		Trainer result;

		result = new Trainer();

		return result;
	}

	public Collection<Trainer> findAll() {
		Collection<Trainer> result;

		Assert.notNull(trainerRepository);
		result = trainerRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Trainer findOne(int trainerId) {
		Trainer result;

		result = trainerRepository.findOne(trainerId);

		return result;
	}

	public void save(Trainer trainer) {
		Assert.notNull(trainer);
		trainerRepository.save(trainer);
	}

	public void delete(Trainer trainer) {
		Assert.notNull(trainer);
		Assert.isTrue(trainer.getId() != 0);
		Assert.isTrue(trainerRepository.exists(trainer.getId()));
		trainerRepository.delete(trainer);

	}

	public Trainer findByPrincipal() {
		Trainer result;
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Trainer findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Trainer result;

		result = trainerRepository.findByUserAccountId(userAccount
				.getId());

		return result;
	}
	public Trainer findOneBySearch(String search) {
		Collection<Trainer> trainers = findAll();
		Trainer trainerB=null;
		for(Trainer t : trainers){
			if(t.getName().contains(search)||t.getSurname().contains(search)||t.getCurriculum().getStatement().contains(search) ){
				trainerB=t;
			break;
			}
		}
		return trainerB;
	}
}