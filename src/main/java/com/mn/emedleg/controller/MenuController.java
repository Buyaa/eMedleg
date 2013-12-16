package com.mn.emedleg.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IMenu;

import com.mn.emedleg.service.IMenuService;

@Controller
public class MenuController {
	@Resource
	private IMenuService service;

	@RequestMapping(value="/menus/{menuId}", method=RequestMethod.POST)
	public String getAll(ModelMap model,  @PathVariable long menuId) {
		model.addAttribute("menus", service.getAll(menuId));
		return "menus";
	}
	
	@RequestMapping(value="/menu/add", method=RequestMethod.POST)
	public String add(IMenu menu) {
		service.add(menu);
		return "redirect:/menu";
	}
	
	@RequestMapping(value = "/deleteMenu")
	public @ResponseBody String deleteMenu(@RequestParam long menuId) {
		service.delete(menuId);
		return "Content deleted successfully";
	}
	//TODO : ene hereg bolohgui bh
//	@RequestMapping(value = "/toggleContent")
//	public @ResponseBody String likeComment(@RequestParam long contentId) {
//		service.publishUnpublish(contentId);
//		return "success";
//	}
//	
//	@RequestMapping(value="/menu/{id}", method=RequestMethod.POST)
//	public String get(@PathVariable int id, Model model) {
//		model.addAttribute("menu", service.get(id));
//		return "menuDetail";
//	}
}
