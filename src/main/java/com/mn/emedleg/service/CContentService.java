package com.mn.emedleg.service;

import java.util.List;

import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.entity.cms.IItem;

public class CContentService extends AItemService<IContent> implements IContentService{
	@Override
	public void updateContent(IContent content) {
		getDAO().update(content);
	}

	@Override
	public String getContentText(long contentID) {
		IContent content = getDAO().get(contentID);
		return content.getContent();
	}

	@Override
	public List<IItem> getComments(long contentID) {
		IContent content = getDAO().get(contentID);
		return content.getComments();
	}

	@Override
	public IContent get(long id) {
		return getDAO().get(id);
	}

	@Override
	public void setStatus(int status, long contentId) {
		getDAO().get(contentId).setStatus(status);		
	}

	@Override
	public List<IContent> getLatest() {
		return getDAO().listAll();
	}
}
