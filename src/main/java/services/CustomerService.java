package services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Customer;
import domain.Folder;

import repositories.CustomerRepository;
import repositories.FolderRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class CustomerService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private FolderService folderService;

	public CustomerService() {
		super();
	}

	public Customer create() {
		Customer result;
		result = new Customer();
		return result;
	}

	public Customer findOne(int customerId) {
		Customer result;

		result = customerRepository.findOne(customerId);

		return result;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Collection<Customer> showAll() {
		return customerRepository.findAll();
	}

	public void save(Customer c) {
		
		
		if(c.getId()==0){
		customerRepository.save(c);
		c=findAll().get(findAll().size()-1);
		Folder inbox=folderService.create();
		Folder outbox=folderService.create();
		Folder trashbox=folderService.create();
		Folder spambox=folderService.create();
		
		inbox.setName("in box");
		outbox.setName("out box");
		trashbox.setName("trash box");
		spambox.setName("spam box");
		inbox.setActor(c);
		outbox.setActor(c);
		trashbox.setActor(c);
		spambox.setActor(c);
		
		folderService.save(inbox);
		inbox=folderService.findAll().get(folderService.findAll().size()-1);
		folderService.save(outbox);
		outbox=folderService.findAll().get(folderService.findAll().size()-1);
		folderService.save(trashbox);
		trashbox=folderService.findAll().get(folderService.findAll().size()-1);
		folderService.save(spambox);
		spambox=folderService.findAll().get(folderService.findAll().size()-1);
		
		
			c.getFolders().add(inbox);
			c.getFolders().add(outbox);
			c.getFolders().add(trashbox);
			c.getFolders().add(spambox);
		
		}
		
		customerRepository.save(c);
		
		
	}

	public void delete(Customer c) {
		customerRepository.delete(c);

	}

	public Collection<Customer> customerPaidMoreFees() {
		return customerRepository.customerPaidMoreFees();
	}

	public Collection<Customer> customerPaidLessFees() {
		return customerRepository.customerPaidLessFees();

	}

/*	public Customer moreCommentedCustomer() {
		Customer result;
		result = customerRepository.moreCommentedCustomer();
		Assert.notNull(result);

		return result;
	}*/

	public Double averageCommentsPerCustomer() {
		Double result;
		result = customerRepository.averageCommentsPerCustomer();
		Assert.notNull(result);

		return result;
	}
	
	public Customer findByPrincipal() {
		Customer result;
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
		}
		public Customer findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Customer result;

		result = customerRepository.findByUserAccountId(userAccount.getId()); 

		return result;
		}

}