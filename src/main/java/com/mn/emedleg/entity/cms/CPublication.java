package com.mn.emedleg.entity.cms;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.mn.emedleg.entity.CUser;

@Entity
@DiscriminatorValue("pub")
public class CPublication extends AContent {
	
	public void setParent(IMenu parent){
		this.parentMenu=parent;
	}
	public CPublication(){}
	
	public CPublication(CUser user, String text, String title,	IMenu parent) {
		super(user, text, title);
		this.parentMenu = parent;
		if(parentMenu!=null)
			add();
	}
	@Override
	public void add() {
		if(parentMenu!=null)
			parentMenu.addChild(this);
	}
	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAbbrevation(){
		return content.substring(0, 50);
	}
}
