package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class BulletinBoard extends DomainEntity{

	

		public BulletinBoard(){
			super();
					}
		
		private Date publishedMoment;
		private String title;
		private String description;
		
		@Past
		@NotNull
		public Date getPublishedMoment() {
			return publishedMoment;
		}
		public void setPublishedMoment(Date moment) {
			this.publishedMoment = moment;
		}
		@NotBlank
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		@NotBlank
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
}
