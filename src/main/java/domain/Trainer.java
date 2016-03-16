package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
@Entity
@Access(AccessType.PROPERTY)
public class Trainer extends Actor{

	


		public Trainer(){
		super();
		this.services= new ArrayList<Service>();
	}
		private String picture;
		
	public String getPicture(){
		return picture;
	}
	public void setPicture(String picture){
		this.picture=picture;
	}
	private Curriculum curriculum;
	private Collection<Service> services;
	
	@Valid
	@OneToOne(optional = true)
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	@Valid
	@ManyToMany
	public Collection<Service> getServices() {
		return services;
	}
	public void setServices(Collection<Service> services) {
		this.services = services;
	}
}
