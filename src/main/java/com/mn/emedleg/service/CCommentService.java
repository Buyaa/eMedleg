package com.mn.emedleg.service;


import com.mn.emedleg.entity.cms.IComment;

public class CCommentService extends AItemService<IComment> implements ICommentService {

	@Override
	public void incrementLikeCount(long commentID) {
		IComment comment= getDAO().get(commentID);
		comment.incrementLikeCount();
	}

	@Override
	public void incrementDislikeCount(long commentID) {
		IComment comment= getDAO().get(commentID);
		comment.incrementDislikeCount();
	}

	@Override
	public void incrementLikeCount(IComment comment) {
		comment.incrementLikeCount();
	}

	@Override
	public void incrementDislikeCount(IComment comment) {
		comment.incrementDislikeCount();
	}

}
