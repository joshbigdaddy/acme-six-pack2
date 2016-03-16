package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import security.UserAccountService;
import domain.Actor;
import domain.Folder;
import domain.Message;
import domain.SpamWords;

@Service
@Transactional
public class ActorService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private ActorRepository actorRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private FolderService folderService;
	@Autowired
	private SpamWordsService spamWordsService;

	// Constructors -----------------------------------------------------------

	public ActorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Collection<Actor> findAll() {
		Collection<Actor> result;

		result = actorRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Actor findOne(int actorId) {
		Assert.isTrue(actorId != 0);

		Actor result;

		result = actorRepository.findOne(actorId);
		Assert.notNull(result);

		return result;
	}

	public void save(Actor actor) {
		Assert.notNull(actor);

		actorRepository.save(actor);
	}

	public void delete(Actor actor) {
		Assert.notNull(actor);
		Assert.isTrue(actor.getId() != 0);
		Assert.isTrue(actorRepository.exists(actor.getId()));

		actorRepository.delete(actor);
	}

	// Other business methods -------------------------------------------------

	public Actor findByPrincipal() {
		Actor result;
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccountActor(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Actor findByUserAccountActor(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Actor result;

		result = actorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

	public UserAccount findUserAccount(Actor actor) {
		Assert.notNull(actor);

		UserAccount result;

		result = userAccountService.findByUsername(actor);

		return result;
	}

	public void enviaMensaje(Integer senderID, Integer recipientID,
			String subject, String body) {
			Message message = messageService.create();
			message.setSender(senderID);
			message.setRecipient(recipientID);
			message.setSubject(subject);
			message.setBody(body);
			message.setSendMoment(new Date(System.currentTimeMillis() - 1));

			if (mensajeEsSpam(message)) {
			message.setSpam(true);
			}

			messageService.save(message);
			message = messageService.findAll().get(
			messageService.findAll().size() - 1);
			Actor sender = this.findOne(senderID);
			Actor recipient = this.findOne(recipientID);
			Assert.notNull(sender);
			Assert.notNull(recipient);
			for (Folder f : sender.getFolders()) {
			if (f.getName().equalsIgnoreCase("out box")) {
			f.getMessages().add(message);
			folderService.save(f);
			break;
			}
			}
			if (message.isSpam()) {
			for (Folder f : recipient.getFolders()) {
			if (f.getName().equalsIgnoreCase("spam box")) {
			f.getMessages().add(message);
			folderService.save(f);
			break;
			}
			}
			} else {
			for (Folder f : recipient.getFolders()) {
			if (f.getName().equalsIgnoreCase("in box")) {
			f.getMessages().add(message);
			folderService.save(f);
			break;
			}
			}
			}

			}

			private boolean mensajeEsSpam(Message message) {
			// TODO Auto-generated method stub
			boolean res = false;
			SpamWords sw = spamWordsService.findFirst();
			if (sw != null) {
			for (String s : sw.getWords()) {
			if (message.getBody().contains(s)
			|| message.getSubject().contains(s)) {
			res = true;
			}
			}
			}
			return res;
			}

}
