package com.mn.emedleg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IComment;
import com.mn.emedleg.service.ICommentService;


@Controller
@RequestMapping("/admin")
public class CommentContoller {

	private ICommentService service;
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody IComment comment) {
		service.add(comment);
		return "Success";
	}
	
	@RequestMapping(value = "/comment", method=RequestMethod.DELETE)
	public @ResponseBody String deleteComment(@RequestParam long commentId) {
		service.delete(commentId);
		return "Success";
	}
	@RequestMapping(value = "/like", method=RequestMethod.POST)
	public @ResponseBody String likeComment(@RequestParam long commentId) {
		service.incrementLikeCount(commentId);
		return "Success";
	}
	@RequestMapping(value = "/dislike", method=RequestMethod.POST)
	public @ResponseBody String dislikeComment(@RequestParam long commentId) {
		service.incrementDislikeCount(commentId);
		return "Success";
	}
// TODO: exception handler
//	@ExceptionHandler(value=NoSuchResourceException.class)
//	public ModelAndView handle(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		mv.getModel().put("e", e);
//		mv.setViewName("noSuchResource");
//		return mv;
//	}
}
