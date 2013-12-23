package com.mn.emedleg.entity.cms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class CComment implements IComment{
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne(targetEntity=AContent.class)
	@JoinColumn(name="content_id")
	private IContent parentContent;
	private int likeCount, dislikeCount;
	private String userName;
	private String message;
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date createdDate;
	
	
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
	@JsonBackReference
	public IContent getParentContent() {
		return parentContent;
	}
	public long getId() {
		return id;
	}
	@JsonBackReference
	public void setParentContent(IContent parentContent) {
		this.parentContent = parentContent;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CComment(){
		this.createdDate=new Date();
	}	
	public int getLikeCount() {
		return likeCount;
	}

	public void incrementLikeCount() {
		this.likeCount++;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void incrementDislikeCount() {
		this.dislikeCount++;
	}
	
	public void setPublication(IContent content){
		this.parentContent=content;
	}
	
	@Override
	public void add() {
		if(parentContent!=null)
			parentContent.addComment(this);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(parentContent!=null)
			return parentContent.deleteComment();
		return false;
	}

	public CComment(IContent publication, String user, String message) {
		this.userName=user;
		this.message=message;
		this.parentContent = publication;
		this.createdDate=new Date();
		add();
	}
	@Override
	public String getTitle() {
		return message;
	}
	@Override
	public String getCreatedDate(){
		return createdDate.toString();
	}
}
