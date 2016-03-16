package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import domain.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	@Query("select c from Customer c where c.feePayments.size=(select max(c.feePayments.size) from Customer c)")
	Collection<Customer> customerPaidMoreFees();
	
	@Query("select c from Customer c where c.feePayments.size=(select min(c.feePayments.size) from Customer c)")
	Collection<Customer> customerPaidLessFees();
	
	/*@Query("select c from Customer c where c.deletedComments=(select max(c.deletedComments) from Customer c)")
	Customer moreCommentedCustomer();
	*/
	@Query("select c from Customer c where c.deletedComments=(select max(c.deletedComments) from Customer c)")
	Collection<Customer> customerMoreCommentsDeleted();
	
	@Query("select avg(c.comments.size) from Customer c")
	Double averageCommentsPerCustomer();
	
	@Query("select c from Customer c where c.userAccount.id = ?1")
	Customer findByUserAccountId(int userAccountId);
	
	@Query("select c from Customer c where c.invoices.size=(select max(c.invoices.size) from Customer c)")
	Collection<Customer> maxInvoicesCustomer();
	@Query("select c from Customer c where c.invoices.size=0")
	Collection<Customer> zeroInvoicesCustomer();
	

}