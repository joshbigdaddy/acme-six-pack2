package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public class SocialIdentity extends DomainEntity{

	
		public SocialIdentity(){
			super();
		}
	private String nick;
	private String socialNetwork;
	private String picture;
	private String url;
	
	@NotBlank
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@NotBlank
	public String getSocialNetwork() {
		return socialNetwork;
	}
	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}
	@URL
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@URL
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	


	
}
