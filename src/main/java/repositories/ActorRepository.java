package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import domain.Actor;


@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer>{
	@Query("select a from Actor a where a.userAccount.id = ?1")
	Actor findByUserAccountId(int userAccountId);
	
	@Query("select f.actor from Folder f where f.name='spam box' and f.messages.size=(select max(f.messages.size) from Folder f where f.name='spam box')")
	Collection<Actor> moreSpamMessages();
	
	@Query("select avg(a.comments.size) from Actor a")
	Double averageCommentsActors();
}