package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;




@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor{

	public Customer(){
		super();
		
		feePayments= new HashSet<FeePayment>();
		invoice = new HashSet<Invoice>();
		activities = new HashSet<Activity>();
		
	}
	

private SocialIdentity socialIdentity;
private CreditCard creditCard;
private Collection<FeePayment> feePayments;
private Collection<Invoice> invoice;
private Collection<Activity> activities;


@Valid
@OneToOne(optional = true)
public SocialIdentity getSocialIdentity() {
	return socialIdentity;
}

public void setSocialIdentity(SocialIdentity socialIdentity) {
	this.socialIdentity = socialIdentity;
}

@Valid
@OneToOne(optional=true)
public CreditCard getCreditCard() {
	return creditCard;
}

public void setCreditCard(CreditCard creditCard) {
	this.creditCard = creditCard;
}

@Valid
@OneToMany(mappedBy="customer")
public Collection<FeePayment> getFeePayments() {
	return feePayments;
}

public void setFeePayments(Collection<FeePayment> feePayments) {
	this.feePayments = feePayments;
}

@Valid
@OneToMany(mappedBy="customer")
public Collection<Invoice> getInvoices() {
	return invoice;
}

public void setInvoices(Collection<Invoice> invoice) {
	this.invoice = invoice;
}


@ManyToMany
public Collection<Activity> getActivities() {
	return activities;
}

public void setActivities(Collection<Activity> activities) {
	this.activities = activities;
}

}
