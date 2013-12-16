package com.mn.emedleg.service;


import com.mn.emedleg.entity.cms.IComment;

public interface ICommentService extends IItemService<IComment>{
	public void incrementLikeCount(long commentID);
	public void incrementDislikeCount(long commentID);
	public void incrementLikeCount(IComment comment);
	public void incrementDislikeCount(IComment comment);
}
