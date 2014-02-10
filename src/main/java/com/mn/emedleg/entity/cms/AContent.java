package com.mn.emedleg.entity.cms;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mn.emedleg.entity.CUser;

@Entity (name="acontent")
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
	private String introText;
	private int status;
	private Date publishedDate;
	private int hitCount;
	private String introImage;
	private String badges;
	
	public String getIntroText() {
		return introText;
	}

	public void setIntroText(String introText) {
		this.introText = introText;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public String getIntroImage() {
		return introImage;
	}

	public void setIntroImage(String introImage) {
		this.introImage = introImage;
	}

	public String getBadges() {
		return badges;
	}

	public void setBadges(String badges) {
		this.badges = badges;
	}

	public IMenu getParentMenu() {
		return parentMenu;
	}
	
	public void setParentMenu(IMenu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
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
	@Override
	public List<IItem> getComments(){
		return comments;
	}
	@Override
	public String getContent() {
		return content;
	}
}
