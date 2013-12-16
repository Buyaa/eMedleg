package com.mn.emedleg.service;


import java.util.List;


import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.entity.cms.IMenu;

public class CMenuService extends AItemService<IMenu> implements IMenuService {

	@Override
	public List<IContent> getContents(long menuID) {
		IMenu menu =getDAO().get(menuID); 
		return menu.getContents();
	}

	@Override
	public List<IMenu> getChildren(long menuID) {
		return getDAO().listAll(menuID);
	}

	@Override
	public List<IMenu> getTopMenus() {
		return getDAO().listAll();
	}
	
	
}
