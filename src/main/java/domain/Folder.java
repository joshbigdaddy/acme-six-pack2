package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import domain.DomainEntity;


@Entity
@Access(AccessType.PROPERTY)
public class Folder extends DomainEntity{
	
	public Folder(){
		super();
	}
private String name;
@NotBlank
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private Actor actor;
private Collection<Message> messages;

@Valid
@ManyToOne(optional=false)
public Actor getActor(){
return actor;
}

public void setActor(Actor actor){
this.actor=actor;
}
@Valid
@ManyToMany
public Collection<Message> getMessages(){
return messages;
}

public void setMessages(Collection<Message> message){
this.messages=message;
}



}
