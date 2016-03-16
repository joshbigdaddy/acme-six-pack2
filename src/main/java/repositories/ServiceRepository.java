package repositories;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer>{

	@Query("select s from Service s where s.gym.size=(select max(s.gym.size) from Service s)")
	Collection<Service> mostPopular();
	
	@Query("select s from Service s where s.gym.size=(select min(s.gym.size) from Service s)")
	Collection<Service> lessPopular();
	
	@Query("select s from Service s where s.comments.size=(select max(s.comments.size) from Service s)")
	Collection<Service> moreCommentedService();
	
	@Query("select avg(s.comments.size) from Service s")
	Double averageCommentsPerService();
	
	@Query("select s, s.trainers.size from Service s")
	Map<Service,Integer> servicesAndTrainers();
	
	@Query("select s from Service s where s.trainers.size=(select max(s.trainers.size) from Service s)")
	Collection<Service> maxTrainersService();
}

