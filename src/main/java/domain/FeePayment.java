package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public class FeePayment extends DomainEntity{
	
	public FeePayment(){
		super();
		invoiced=false;
		
	}
private Date paymentMoment;	
private Date activeDay;
private Date inactiveDay;
private boolean invoiced;

@NotNull
@Past
public Date getPaymentMoment() {
	return paymentMoment;
}
public void setPaymentMoment(Date paymentMoment) {
	this.paymentMoment = paymentMoment;
}
@NotNull
public Date getActiveDay() {
	return activeDay;
}
public void setActiveDay(Date activeDay) {
	this.activeDay = activeDay;
}
@NotNull
public Date getInactiveDay() {
	return inactiveDay;
}
public void setInactiveDay(Date inactiveDay) {
	this.inactiveDay = inactiveDay;
}

public boolean getInvoiced(){
	return invoiced;
}
public void setInvoiced(boolean invoiced){
	this.invoiced=invoiced;
}

private Customer customer;
private Gym gym;
private CreditCard creditCard;
@Valid
@ManyToOne(optional=false)
public Gym getGym() {
	return gym;
}
public void setGym(Gym gym) {
	this.gym = gym;
}
@Valid
@ManyToOne(optional=false)
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

@Valid
@ManyToOne(optional=false)
public CreditCard getCreditCard() {
	return creditCard;
}
public void setCreditCard(CreditCard creditCard) {
	this.creditCard = creditCard;
}


}
