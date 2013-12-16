package com.mn.emedleg.entity.cms;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mn.emedleg.entity.CUser;
@Entity
@DiscriminatorValue("menu")
public class CMenu extends AMenu {
	
	public CMenu(){
		
	}
	
	public CMenu(IMenu parent, String title, CUser user ) {
		super(title, user);
		this.parent = parent;
		if(parent!=null)
			add();
	}
	@JsonBackReference
	public void setParent(IMenu parent){
		this.parent=parent;
	}
	
	@JsonManagedReference
	@Override
	public List <IContent> getContents() {
		return contents;
	}
	
	@Override
	public void addChild(IContent childContent) {
		if(!contents.contains(childContent))
			contents.add(childContent);
	}
		
}
