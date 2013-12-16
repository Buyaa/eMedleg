package com.mn.emedleg.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.service.IContentService;

@Controller
public class ContentController {
	@Resource
	private IContentService service;

	@RequestMapping(value="/contents/{menuId}", method=RequestMethod.POST)
	public String getAll(ModelMap model,  @PathVariable long menuId) {
		model.addAttribute("contents", service.getAll(menuId));
		return "publication";
	}
	
	@RequestMapping(value="/content/add", method=RequestMethod.POST)
	public String add(IContent content) {
		service.add(content);
		return "redirect:/publication";
	}
	
	@RequestMapping(value = "/deleteContent")
	public @ResponseBody String deleteContent(@RequestParam long contentId) {
		service.delete(contentId);
		return "Content deleted successfully";
	}
	
	@RequestMapping(value = "/toggleContent")
	public @ResponseBody String likeComment(@RequestParam long contentId) {
		service.publishUnpublish(contentId);
		return "success";
	}
	
	@RequestMapping(value="/content/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("content", service.get(id));
		return "contentDetail";
	}
	
	@RequestMapping(value="/content/update/{id}", method=RequestMethod.POST)
	public String update(IContent newContent, @PathVariable int id) {
		IContent oldContent=service.get(id);
		oldContent=newContent;  // ingeh hereg bna uu?
		service.updateContent(oldContent);
		return "redirect:/contentDetail";
	}
}
