package com.mn.emedleg.entity.cms;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mn.emedleg.entity.CUser;

@Entity
@Inheritance
public abstract class AMenu extends AItem implements IMenu {
	@JsonIgnore
	@OneToMany(mappedBy="parentMenu", targetEntity=AContent.class)
	protected List<IContent> contents;
	private int role; 
	@ManyToOne(targetEntity=AMenu.class)
	@JoinColumn(name="parent_id")
	protected IMenu parent;
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getRole() {
		return role;
	}
	@JsonBackReference
	public IMenu getParent() {
		return parent;
	}
	@JsonBackReference
	public void setParent(IMenu parent) {
		this.parent = parent;
	}
	@JsonManagedReference
	public List<IContent> getContents() {
		return contents;
	}
	public AMenu(){
		contents = new ArrayList<IContent>();
	}
	public AMenu(String title, CUser user) {
		this.title = title;
		this.cuser = user;
		contents = new ArrayList<IContent>();
	}
	public AMenu(String title, CUser user, IMenu parent) {
		this.title = title;
		this.cuser = user;
		this.parent=parent;
		contents = new ArrayList<IContent>();
	}
	@Override
	public void add() {
		if(parent!=null)
			parent.addChild(this);
	}

	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public void addChild(IContent childContent) {

	}
	@Override
	public void addChild(IMenu childMenu) {
		
	}
	
	@Override
	public List<IMenu> getChildren(){
		return null;
	}

}
