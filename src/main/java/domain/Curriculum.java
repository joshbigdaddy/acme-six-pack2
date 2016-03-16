package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Curriculum extends DomainEntity {

	public Curriculum() {
		super();

	}

	private String picture;
	private String statement;
	private ArrayList<String> skills;
	private ArrayList<String> likes;
	private ArrayList<String> dislikes;
	private Date updatedMoment;

	@NotBlank
	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	
	public ArrayList<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}
	
	public ArrayList<String> getDislikes() {
		return dislikes;
	}

	public void setDislikes(ArrayList<String> dislikes) {
		this.dislikes = dislikes;
	}
	
	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	
	@URL
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@NotNull
	public Date getUpdatedMoment() {
		return updatedMoment;
	}

	public void setUpdatedMoment(Date updatedMoment) {
		this.updatedMoment= updatedMoment;
	}
}
