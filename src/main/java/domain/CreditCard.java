package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import domain.DomainEntity;


@Entity
@Access(AccessType.PROPERTY)
public class CreditCard extends DomainEntity{

	public CreditCard(){
		super();
	}
	
	private String holderName;
	private String brandName;
	private Integer expirationMonth;
	private Integer expirationYear;
	private String cvvCode;
	private String number;
	
	@CreditCardNumber
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@NotBlank
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	@NotBlank
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@NotNull
	@Range(min=1,max=12)
	public Integer getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	@NotNull
	public Integer getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}
	@NotBlank
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	
	
	
}
