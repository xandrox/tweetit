package de.adorsys.tweetit.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Tweet implements java.io.Serializable {

	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	Long id = null;
	
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		if (id != null) {
			return id.equals(((Tweet) that).id);
		}
		return super.equals(that);
	}

	@Override
	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		}
		return super.hashCode();
	}

	@ManyToOne
	private User emitter;

	public User getEmitter() {
		return this.emitter;
	}

	public void setEmitter(final User emitter) {
		this.emitter = emitter;
	}

	@Column
	private String message;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	private @Temporal(TemporalType.DATE)
	Date cdat;

	public Date getCdat() {
		return this.cdat;
	}

	public void setCdat(final Date cdat) {
		this.cdat = cdat;
	}

	public String toString() {
		String result = "";
		if (message != null && !message.trim().isEmpty())
			result += message;
		return result;
	}
}