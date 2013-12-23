package com.mn.emedleg.entity.cms;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mn.emedleg.entity.CUser;

@MappedSuperclass
public abstract class AItem implements IItem{
	@Id
	@GeneratedValue
	private long id;
	protected String title;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	protected CUser cuser;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	
	public CUser getCuser() {
		return cuser;
	}
	public void setCuser(CUser cuser) {
		this.cuser = cuser;
	}
	public long getId(){
		return id;
	}
	public AItem(){
		createdDate=new Date();
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public String getUserName() {
		return cuser.getUserName();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatedDate(){
		return createdDate.toString();
	}
}
