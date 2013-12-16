package com.mn.emedleg.entity.cms;

import java.util.List;

public interface IMenu extends IItem{
	public void addChild(IContent childContent);
	public void addChild(IMenu childMenu);
	public List <IContent> getContents();
	public List <IMenu> getChildren();
}
