package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Room extends DomainEntity {
	public Room() {
		super();
	}

	private String name;
	private String description;
	private String pictures;
	private Integer seats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	private Collection<Activity> activity;
    @Valid
	@OneToMany(mappedBy = "room")
	public Collection<Activity> getActivity() {
		return activity;
	}

	public void setActivity(Collection<Activity> activity) {
		this.activity = activity;
	}
}
