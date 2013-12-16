package com.mn.emedleg.entity.cms;

public interface IComment extends IItem{
	public void incrementLikeCount();
	public void incrementDislikeCount();
	public int getDislikeCount();
	public int getLikeCount();
}
