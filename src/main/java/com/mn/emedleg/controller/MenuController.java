package com.mn.emedleg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IMenu;
import com.mn.emedleg.service.IMenuService;

@Controller
@RequestMapping("/admin")
public class MenuController {
	@Autowired
	private IMenuService service;

	@RequestMapping(value="/menu", method=RequestMethod.POST)
	public @ResponseBody String createMenu(@RequestBody IMenu menu) {
		service.add(menu);
		return "Added";
	}
	
	@RequestMapping(value="/menu/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String add(@PathVariable long id){
		service.delete(id);
		return "Menu deleted successfully";
	}
	
//	@RequestMapping(value = "/deleteMenu")
//	public @ResponseBody String deleteMenu(@RequestBody IMenu menu) {
//		service.delete(menu);
//		return "Menu deleted successfully";
//	}
}
