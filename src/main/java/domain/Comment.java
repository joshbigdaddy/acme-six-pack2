package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import domain.DomainEntity;


@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity{

	public Comment(){
		super();
		this.deleted=false;
		this.moment= new Date();
	}
	
	private Date moment;
	private String text;
	private Integer starRating;
	private Boolean deleted;
	
	@Past
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@NotBlank
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Range(min=0,max=5)
	public Integer getStarRating() {
		return starRating;
	}
	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}
	@NotNull
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	private Actor actor;
	
	@Valid
	@ManyToOne(cascade = {CascadeType.ALL})
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
