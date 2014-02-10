package com.mn.emedleg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.service.IContentService;

@Controller
@RequestMapping("/admin")
public class ContentController {
	@Autowired
	private IContentService service;

	@RequestMapping(value="/content", method=RequestMethod.POST)
	public @ResponseBody String createContent(@RequestBody IContent content) {
		service.add(content);
		return "Added";
	}
	
	@RequestMapping(value = "/content",  method=RequestMethod.DELETE)
	public @ResponseBody String deleteContent(@RequestParam long contentId) {
		service.delete(contentId);
		return "Content deleted successfully";
	}
	
//	@RequestMapping(value = "/content",  method=RequestMethod.DELETE)
//	public @ResponseBody String deleteContent(@RequestParam IContent content) {
//		service.delete(content);
//		return "Content deleted successfully";
//	}
	
	@RequestMapping(value = "/content/status",  method=RequestMethod.PUT)
	public @ResponseBody String setStatus(@RequestParam long contentId, int status) {
		service.setStatus(status, contentId);
		return "Success";
	}
	
	@RequestMapping(value="/content/{id}", method=RequestMethod.PUT)
	public @ResponseBody String update(@RequestParam IContent newContent, @PathVariable int id) {
		IContent oldContent=service.get(id);
		oldContent=newContent;  // ingeh hereg bna uu?
		service.updateContent(oldContent);
		return "Success";
	}
}
