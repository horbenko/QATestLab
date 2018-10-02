package com.qatestlab.cinema.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PERSISTENT_LOGINS")
public class PersistentLogin implements Serializable{

	@Id
	private String series;

	@Column(name = "USERNAME", unique = true, nullable = false, length = 30)
	private String username;
	
	@Column(name = "TOKEN", unique = true, nullable = false, length = 64)
	private String token;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_USED")
	private Date lastUsed;

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date last_used) {
		this.lastUsed = last_used;
	}
	
	
}
