package com.mn.emedleg.entity.cms;

import java.util.List;

public interface IContent extends IItem{
	public boolean update();
	public void addComment(IItem comment);
	public boolean deleteComment();
	public String getContent();
	public List<IItem> getComments();
	public void togglePublish();
}
