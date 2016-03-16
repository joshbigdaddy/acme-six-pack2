package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;
import domain.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Integer>{
	
	@Query("select f.actor from Folder f where f.name='spam box' and f.messages.size=(select max(f.messages.size) from Folder f where f.name='spam box')")
	Collection<Actor> actorSendMoreSpam();
	
	@Query("select avg(f.messages.size) from Folder f")
	Double averageActorMessages();
}

