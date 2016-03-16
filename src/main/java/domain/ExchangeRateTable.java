package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class ExchangeRateTable extends DomainEntity{

	public ExchangeRateTable() {
		super();
	}

	private Double espToEuros;
	private Double frfToEuros;
	private Double itlToEuros;
	private Double demToEuros;
	private Double pteToEuros;

	public Double getEspToEuros() {
		return espToEuros;
	}

	public void setEspToEuros(Double espToEuros) {
		this.espToEuros = espToEuros;
	}

	public Double getFrfToEuros() {
		return frfToEuros;
	}

	public void setFrfToEuros(Double frfToEuros) {
		this.frfToEuros = frfToEuros;
	}

	public Double getItlToEuros() {
		return itlToEuros;
	}

	public void setItlToEuros(Double itlToEuros) {
		this.itlToEuros = itlToEuros;
	}

	public Double getDemToEuros() {
		return demToEuros;
	}

	public void setDemToEuros(Double demToEuros) {
		this.demToEuros = demToEuros;
	}

	public Double getPteToEuros() {
		return pteToEuros;
	}

	public void setPteToEuros(Double pteToEuros) {
		this.pteToEuros = pteToEuros;
	}

}
