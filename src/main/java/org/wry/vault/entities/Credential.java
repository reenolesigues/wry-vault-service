package org.wry.vault.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "WRYSEQGEN")
	@SequenceGenerator(name = "WRYSEQGEN", sequenceName = "WRY_SEQ", allocationSize = 1)
	private Integer id;
	
	private String tag;
	
	private String weblink;
	
	private String username;
	
	private String password;
	
	private LocalDateTime dateInserted;
	
	private LocalDateTime dateModified;
	
	private boolean isFavorite;
	
	public Credential() {}

	@JsonGetter
	public Integer getId() {
		return id;
	}

	@JsonIgnore
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getWeblink() {
		return weblink;
	}

	public void setWeblink(String weblink) {
		this.weblink = weblink;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@JsonIgnore
	public LocalDateTime getDateInserted() {
		return dateInserted;
	}

	@JsonIgnore
	public void setDateInserted(LocalDateTime dateInserted) {
		this.dateInserted = dateInserted;
	}

	@JsonIgnore
	public LocalDateTime getDateModified() {
		return dateModified;
	}

	@JsonIgnore
	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	@Override
	public String toString() {
		return "Credential [id=" + id + ", tag=" + tag + ", weblink=" + weblink + ", username=" + username
				+ ", password=" + password + ", dateInserted=" + dateInserted + ", dateModified=" + dateModified
				+ ", isFavorite=" + isFavorite + "]";
	}
	
}
