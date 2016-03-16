package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public class Message extends DomainEntity{
	
	public Message(){
		super();
		this.spam=false;
	}
	
	private Integer sender;
	private Integer recipient;
	private String subject;
	private String body;
	private Date sendMoment;
	private boolean spam;
	
	@NotNull
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	@NotNull
	public Integer getRecipient() {
		return recipient;
	}
	public void setRecipient(Integer recipient) {
		this.recipient = recipient;
	}
	@NotBlank
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Past
	public Date getSendMoment() {
		return sendMoment;
	}
	public void setSendMoment(Date sendMoment) {
		this.sendMoment = sendMoment;
	}
	public boolean isSpam() {
		return spam;
	}
	public void setSpam(boolean spam) {
		this.spam = spam;
	}

}
