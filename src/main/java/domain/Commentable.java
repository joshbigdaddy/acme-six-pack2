package domain;



import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.AccessType;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Commentable extends DomainEntity{

	
	public Commentable(){
		super();
		comments= new HashSet<Comment>();
		
	}
	
	private Collection<Comment> comments;

	@ElementCollection
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
