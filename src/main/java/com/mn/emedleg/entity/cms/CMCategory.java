package com.mn.emedleg.entity.cms;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mn.emedleg.entity.CUser;
@Entity
@DiscriminatorValue("category")
public class CMCategory extends AMenu{
	
	@OneToMany(mappedBy="parent", targetEntity=AMenu.class)
	private List<IMenu> childMenus;
	
	@JsonManagedReference
	public List<IMenu> getChildMenus() {
		return childMenus;
	}
	public CMCategory(){
		childMenus = new ArrayList<IMenu>();
	}
	public CMCategory(String title, CUser user){
		super(title, user);
		childMenus = new ArrayList<IMenu>();
	}
	public CMCategory(String title, CUser user, IMenu parent){
		super(title, user, parent);
		childMenus = new ArrayList<IMenu>();
	}
	@JsonBackReference
	@Override
	public List<IContent> getContents() {
		contents.clear();
		for(IMenu menu : childMenus){
			contents.addAll(menu.getContents());
		}
		return contents;
	}
	@Override
	public void addChild(IMenu childMenu) {
		if(!childMenus.contains(childMenu))
			childMenus.add(childMenu);
	}
	
	@Override
	public List<IMenu> getChildren(){
		return childMenus;
	}
}
