package com.mn.emedleg.entity.cms;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mn.emedleg.entity.CUser;

@Entity
@Inheritance
public abstract class AContent extends AItem implements IContent {
	@Lob
	protected String content;
	
	@JsonIgnore
	@OneToMany(mappedBy="parentContent", targetEntity=CComment.class)
	private List<IItem> comments;
	
	@ManyToOne(targetEntity=AMenu.class)
	@JoinColumn(name="parent_id")
	protected IMenu parentMenu; 
	private boolean publish=false;
	
	@JsonBackReference
	public IMenu getParentMenu() {
		return parentMenu;
	}
	@JsonBackReference
	public void setParentMenu(IMenu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPublish(boolean publish) {
		this.publish = publish;
	}
	public boolean isPublish() {
		return publish;
	}
	public void togglePublish() {
		this.publish = !this.publish;
	}
	public AContent(CUser user, String text, String title) {
		this.cuser = user;
		this.content = text;
		this.title = title;
		comments = new ArrayList<IItem>();
	}
	public AContent(){
		comments = new ArrayList<IItem>();
	}
	
	@Override
	public void addComment(IItem comment) {
		if (comments!=null) {
			if (!comments.contains(comment)) {
				comments.add(comment);
			}
		}
	}
	@Override
	public boolean deleteComment() {
		// TODO Auto-generated method stub
		return false;
	}
	@JsonManagedReference
	@Override
	public List<IItem> getComments(){
		return comments;
	}
	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
}
