package com.mn.emedleg.service;


import java.util.List;

import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.entity.cms.IMenu;

public interface IMenuService extends IItemService<IMenu>{
	public List <IContent> getContents(long menuID);
	public List <IMenu> getChildren(long menuID);
	public List <IMenu> getTopMenus();
}
