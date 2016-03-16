package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import repositories.BulletinBoardRepository;
import security.LoginService;
import security.UserAccount;
import security.UserAccountService;
import domain.Actor;
import domain.Administrator;
import domain.BulletinBoard;
import domain.Gym;
@Service
@Transactional
public class BulletinBoardService {
	
	

		// Managed repository -----------------------------------------------------

		@Autowired
		private BulletinBoardRepository bulletinBoardRepository;

		// Supporting services ----------------------------------------------------

		// Constructors -----------------------------------------------------------

		public BulletinBoardService() {
			super();
		}

		// Simple CRUD methods ----------------------------------------------------
		public BulletinBoard create() {
			BulletinBoard result;

			result = new BulletinBoard();

			return result;
		}
		public Collection<BulletinBoard> findAll() {
			Collection<BulletinBoard> result;

			result = bulletinBoardRepository.findAll();
			Assert.notNull(result);

			return result;
		}

		public BulletinBoard findOne(int bulletinBoardId) {
			Assert.isTrue(bulletinBoardId != 0);

			BulletinBoard result;

			result = bulletinBoardRepository.findOne(bulletinBoardId);
			Assert.notNull(result);

			return result;
		}

		public void save(BulletinBoard bulletinBoard) {
			Assert.notNull(bulletinBoard);

			bulletinBoardRepository.save(bulletinBoard);
		}

		public void delete(BulletinBoard bulletinBoard) {
			Assert.notNull(bulletinBoard);
			Assert.isTrue(bulletinBoard.getId() != 0);
			Assert.isTrue(bulletinBoardRepository.exists(bulletinBoard.getId()));

			bulletinBoardRepository.delete(bulletinBoard);
		}

		// Other business methods ------------------------------------------------

		public Collection<BulletinBoard> findBySearch(String search){
			Collection<BulletinBoard> bulletinBoards = findAll();
			List<BulletinBoard> bulletinBoardB=new ArrayList<BulletinBoard>();
			for(BulletinBoard b : bulletinBoards){
				
					if(b.getTitle().contains(search) || b.getDescription().contains(search)){
						bulletinBoardB.add(b);
					
				}
			}
			return bulletinBoardB;
		}

}
