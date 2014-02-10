package com.mn.emedleg.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name="cuser")
public class CUser implements IUser, UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	@Column(length = 64, nullable = false)
	private String password;
	private Date registeredDate;
	@Column(unique = true, length = 50, nullable = false)
	private String emailID;
	private boolean enabled;
	
//	@Enumerated(EnumType.STRING)
    @Column(name = "userRole")
    private Role role;
    //  get and set
	public enum Role {
		ROLE_USER, ROLE_PUBLICIST, ROLE_ADMIN
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getRole() {
		return role.ordinal();
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public CUser(){}
	public CUser(String firstName) {
		this.firstName = firstName;
		this.registeredDate=new Date();
	}
	public CUser(String firstName, String password) {
		this.firstName = firstName;
		this.password = password;
		this.registeredDate=new Date();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return firstName+" "+lastName;
	}
	@Override
	public String getRegisteredDate() {
		return registeredDate.toString();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<String> roles = this.getRoles();

		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return emailID;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {

		return enabled;
	}
	public Set<String> getRoles() {
		 Set<String> roles = new HashSet<String>();
		 roles.add(role.name());
		 return roles;
	}
}
