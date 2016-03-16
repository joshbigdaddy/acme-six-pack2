package services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Actor;
import domain.Folder;
import domain.Message;

import repositories.MessageRepository;

@Service
@Transactional
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	

	// Supporting Services
	@Autowired
	private ActorService actorService;
	@Autowired
	private FolderService folderService;

	// Constructor

	public MessageService() {
		super();
	}

	public Message create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		Message m;
		m = new Message();
		return m;
	}

	public Message findOne(int mId) {
		Message result;

		result = messageRepository.findOne(mId);

		return result;
	}

	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	public void save(Message m) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		messageRepository.save(m);
	}

	public void delete(Message m) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		boolean toTrash=false;
		Actor a= actorService.findOne(m.getRecipient());
		Collection<Folder> folders=a.getFolders();
		for(Folder f:folders){
			if(f.getMessages().contains(m)){
				if(!f.getName().equalsIgnoreCase("trash box")){
					f.getMessages().remove(m);
					
					toTrash=true;
				}else{
					f.getMessages().remove(m);
					messageRepository.delete(m);
				
				}
				folderService.save(f);
				break;
			}
		}
		if(toTrash){
			for(Folder f:folders){
				if(f.getName().equalsIgnoreCase("trash box")){
					f.getMessages().add(m);
					folderService.save(f);
					break;
				}
			}
		}
	}

	// Other bussines methods
}