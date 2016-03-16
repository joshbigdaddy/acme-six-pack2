package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


@Entity
@Access(AccessType.PROPERTY)
public class Service extends Commentable{

	
		public Service(){
			super();
			gym=new HashSet<Gym>();
		
		}
		
	private String name;
	private String description;
	private String url;
	
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
	@URL
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
		
		
	}
	
	private Collection<Gym> gym;
	private Collection<Activity> activities;
	
	@Valid
	@OneToMany(mappedBy="service")
	public Collection<Activity> getActivities(){
		return activities;
	}
	public void setActivities(Collection<Activity> activities){
		this.activities=activities;
	}
	
	@Valid
	@ManyToMany(mappedBy="service")
	public Collection<Gym> getGym() {
		return gym;
	}
	public void setGym(Collection<Gym> gym) {
		this.gym = gym;
	}
	
}
