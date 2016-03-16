package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym,Integer>{
	@Query("select g from Gym g where g.feePayments.size=(select max(g.feePayments.size) from Gym g)")
	Collection<Gym> mostPopular();

	@Query("select g from Gym g where g.feePayments.size=(select min(g.feePayments.size) from Gym g)")
	Collection<Gym> lessPopular();
	
	@Query("select g from Gym g where g.comments.size=(select max(g.comments.size) from Gym g)")
	Collection<Gym> moreCommentedGym();
	
	@Query("select avg(g.comments.size) from Gym g")
	Double averageCommentsPerGym();
	
	@Query("select avg(g.rooms.size) from Gym g")
	Double averageRoomsPerGym();
	
	@Query("select g from Gym g where g.rooms.size>(select avg(g.rooms.size) from Gym g)")
	Collection<Gym> moreRoomsPerGymThanAverage();
	
	@Query("select g from Gym g where g.rooms.size<(select avg(g.rooms.size) from Gym g)")
	Collection<Gym> lessRoomsPerGymThanAverage();
	@Query("select avg(g.activities) from Gym g group by g.services")
	Double averageActivitiesPerGym();
	
}

