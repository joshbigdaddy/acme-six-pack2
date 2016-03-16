package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Activity extends DomainEntity {

	public Activity() {
		super();
	}

	private String title;
	private String description;
	private String pictures;
	private Double duration;
	private Integer availableSeats;
	private Date date;
	private Date startingTime;

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	@NotNull
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@NotNull
	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	@NotNull
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@NotNull
	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}
	
	private Service service;
	private Room room;
	
	@Valid
	@ManyToOne(optional=false)
	public Room getRoom(){
		return room;
	}
	public void setRoom(Room room){
		this.room=room;
	}
	
	@Valid
	@ManyToOne(optional=false)
	public Service getService(){
		return service;
	}
	public void setService(Service service){
		this.service=service;
	}
}
