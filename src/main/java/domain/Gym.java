package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Gym extends Commentable {

	public Gym() {
		super();

		this.feePayments = new ArrayList<FeePayment>();
		this.comment = new ArrayList<Comment>();
		this.service = new ArrayList<Service>();
	}

	private String name;
	private String description;
	private String postalAddress;
	private String telephone;
	private Double fee;
	private String picture;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotBlank
	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	@NotBlank
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@NotNull
	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@URL
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	private Collection<FeePayment> feePayments;
	private Collection<Service> service;
	private Collection<BulletinBoard> bulletinBoards;
	public Collection<Comment> comment;
	private Collection<ActivityPlans> activityPlans;

	@Valid
	@OneToMany
	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}

	@Valid
	@OneToMany(mappedBy = "gym")
	public Collection<FeePayment> getFeePayments() {
		return feePayments;
	}

	public void setFeePayments(Collection<FeePayment> feePayments) {
		this.feePayments = feePayments;
	}

	@Valid
	@ManyToMany
	public Collection<Service> getService() {
		return service;
	}

	public void setService(Collection<Service> service) {
		this.service = service;
	}

	@Valid
	@OneToMany()
	public Collection<BulletinBoard> getBulletinBoards() {
		return bulletinBoards;
	}

	public void setBulletinBoards(Collection<BulletinBoard> bulletinBoards) {
		this.bulletinBoards = bulletinBoards;
	}

	@Valid
	@OneToMany()
	public Collection<ActivityPlans> getActivityPlans() {
		return activityPlans;
	}

	public void setActivityPlans(Collection<ActivityPlans> activityPlans) {
		this.activityPlans = activityPlans;
	}

	private Collection<Room> rooms;

	@NotEmpty
	@Valid
	@ElementCollection
	public Collection<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}
}
