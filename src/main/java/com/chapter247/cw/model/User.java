package com.chapter247.cw.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;


/**
 *
 * @author Krishna Bhargava
 *
 */
@Entity
@Table(name="users")
public class User {
	

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	private Set<Content> content = new HashSet<Content>(0);
	
	/**
	 * @return the content
	 */
	
	
	public Set<Content> getContent() {
		return content;
	}



	/**
	 * @param content the content to set
	 */
	public void setContent(Set<Content> content) {
		this.content = content;
	}

	
	
	
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id", 
					nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>();  
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}



	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	

	public User() {
		super();
		
	}
	

	public User(int id, String email_address, boolean status, Set<Role> roles) {
		super();
		this.id = id;
		
		this.roles = roles;
	}
	
	
	public User(int id, String email_address) {
		super();
		this.id = id;
		
	}



	
	
	
}
