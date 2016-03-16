package services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Actor;
import domain.Folder;

import repositories.FolderRepository;

@Service
@Transactional
public class FolderService {

	@Autowired
	private FolderRepository folderRepository;

	// Supporting Services

	// Constructor

	public FolderService() {
		super();
	}

	public Folder create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		Folder f;
		f = new Folder();
		return f;
	}

	public Folder findOne(int fId) {
		Folder result;

		result = folderRepository.findOne(fId);

		return result;
	}

	public List<Folder> findAll() {
		return folderRepository.findAll();
	}

	public void save(Folder f) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		folderRepository.save(f);
	}

	public void delete(Folder f) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		if (!f.getName().equalsIgnoreCase("in box")
				&& !f.getName().equalsIgnoreCase("out box")
				&& !f.getName().equalsIgnoreCase("spam box")
				&& !f.getName().equalsIgnoreCase("trash box")){
		folderRepository.delete(f);
		}

	}

	// Other bussines methods

	public Collection<Actor> actorSendMoreSpam() {
		return folderRepository.actorSendMoreSpam();
	}

	public Double averageActorMessages() {
		return folderRepository.averageActorMessages();
	}
}