package com.mn.emedleg.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IComment;
import com.mn.emedleg.service.ICommentService;


@Controller
public class CommentContoller {
	@Resource
	private ICommentService service;
	//TODO ene barag hereggui yum shig bna
//	@RequestMapping(value="/comments/{pubId}", method=RequestMethod.POST)
//	public String getAll(Model model,  @PathVariable long pubId) {
//		model.addAttribute("comments", service.getAll(pubId));
//		return "publication";
//	}
	
	@RequestMapping(value="/comment/add", method=RequestMethod.POST)
	public String add(IComment comment) {
		service.add(comment);
		return "redirect:/publication";
	}
	
	@RequestMapping(value = "/deleteComment")
	public @ResponseBody String deleteComment(@RequestParam long commentId) {
		service.delete(commentId);
		return "Comment deleted successfully";
	}
	@RequestMapping(value = "/likeComment")
	public @ResponseBody String likeComment(@RequestParam long commentId) {
		service.incrementDislikeCount(commentId);
		return "success";
	}
	@RequestMapping(value = "/dislikeComment")
	public @ResponseBody String dislikeComment(@RequestParam long commentId) {
		service.incrementLikeCount(commentId);
		return "success";
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
