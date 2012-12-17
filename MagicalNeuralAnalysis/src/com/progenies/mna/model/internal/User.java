package com.progenies.mna.model.internal;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USERS")
@NamedQueries({
	@NamedQuery(name="findByLogin", query="SELECT u from User u where u.login=:login"),
	@NamedQuery(name="findAllUsers", query="SELECT u from User u")
})
public class User implements Serializable
{
	

	public static enum ROLE {DEFAULT, ADMIN, VISITOR};

	@Id
	@Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;
	
	@Basic(optional=false)
	private String name;
	@Basic(optional=false)
	private String login;
	@Basic(optional=false)
	private String password;
	@Basic(optional=false)
	private Boolean active;
	
	@Basic(optional=false)
	private ROLE role=ROLE.DEFAULT;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getIdUser() {
		return idUser;
	}
	public ROLE getRole() {
		return role;
	}
	public void setRole(ROLE role) {
		this.role = role;
	}
	public void setIdUser(Long idUser2) {
		this.idUser=idUser2;
		
	}

	
	
}
