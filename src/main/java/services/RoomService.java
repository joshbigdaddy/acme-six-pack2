package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.RoomRepository;

import domain.BulletinBoard;
import domain.Room;
@Service
@Transactional
public class RoomService {
	
	
		
		

			// Managed repository -----------------------------------------------------

			@Autowired
			private RoomRepository roomRepository;

			// Supporting services ----------------------------------------------------

			// Constructors -----------------------------------------------------------

			public RoomService() {
				super();
			}

			// Simple CRUD methods ----------------------------------------------------
			public Room create() {
				Room result;

				result = new Room();

				return result;
			}
			public Collection<Room> findAll() {
				Collection<Room> result;

				result = roomRepository.findAll();
				Assert.notNull(result);

				return result;
			}

			public Room findOne(int roomId) {
				Assert.isTrue(roomId != 0);

				Room result;

				result = roomRepository.findOne(roomId);
				Assert.notNull(result);

				return result;
			}

			public void save(Room room) {
				Assert.notNull(room);

				roomRepository.save(room);
			}

			public void delete(Room room) {
				Assert.notNull(room);
				Assert.isTrue(room.getId() != 0);
				Assert.isTrue(roomRepository.exists(room.getId()));

				roomRepository.delete(room);
			}

}
