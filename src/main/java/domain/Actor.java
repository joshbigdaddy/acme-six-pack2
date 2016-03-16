package domain;



import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.AccessType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import security.UserAccount;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity{

	
	public Actor(){
		super();
		comments= new HashSet<Comment>();
		folders= new HashSet<Folder>();
	}
	
	
	private String name;
	private String surname;
	private String contactPhone;

	
	@NotBlank
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
private Collection<Folder> folders;
private UserAccount userAccount;
private Integer deletedComments;
private Collection<Comment> comments;


@Valid
@OneToMany(mappedBy="actor")
public Collection<Comment> getComments() {
	return comments;
}

public void setComments(Collection<Comment> comments) {
	this.comments = comments;
}

public Integer getDeletedComments() {
	deletedComments=0;
	
	for(Comment c: comments){
		if(c.getDeleted()==true){
			deletedComments++;
		}
	}
	
	return deletedComments;
}


public void setDeletedComments(Integer deletedComments) {
	this.deletedComments = deletedComments;
}	




	@Valid
	@OneToMany(mappedBy="actor")
	@NotEmpty
	public Collection<Folder> getFolders(){
		return folders;
	}
	public void setFolders(Collection<Folder> folders){
		this.folders=folders;
	}
	
	@NotNull
	@Valid
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
