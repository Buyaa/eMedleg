package com.mn.emedleg.service;


import java.util.List;

import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.entity.cms.IItem;

public interface IContentService extends IItemService<IContent>{
	public void updateContent(IContent content);
	public String getContentText(long contentID);
	public List<IItem> getComments(long contentID);
	public IContent get(long id);
	public void setStatus(int status, long id);
	public List<IContent> getLatest();
}
