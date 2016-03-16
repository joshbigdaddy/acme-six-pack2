package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Invoice extends DomainEntity {

	public Invoice() {
		super();

	}

	private Date creationMoment;
	private String name;
	private String VAT;
	private String description;
	private Double totalCost;

	@NotNull
	@Past
	public Date getCreationMoment() {
		return creationMoment;
	}

	public void setCreationMoment(Date creationMoment) {
		this.creationMoment = creationMoment;
	}

	@NotNull
	public Double getTotalCost() {
		Double aux = 0d;
		for(FeePayment f : feePayment){
		aux+=f.getGym().getFee();
		}
		totalCost=aux;
		return totalCost;
		}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getVAT() {
		return VAT;
	}

	public void setVAT(String VAT) {
		this.VAT = VAT;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Customer customer;
	private Collection<FeePayment> feePayment;

	@Valid
	@ManyToOne(optional = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Valid
	@OneToMany()
	public Collection<FeePayment> getFeePayment() {
		return feePayment;
	}

	public void setFeePayment(Collection<FeePayment> feepayment) {
		this.feePayment = feepayment;
	}
}
