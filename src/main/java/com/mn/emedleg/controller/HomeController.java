package com.mn.emedleg.controller;



import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.cms.IContent;
import com.mn.emedleg.entity.cms.IMenu;
import com.mn.emedleg.service.IContentService;
import com.mn.emedleg.service.IMenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource
	private IMenuService menuService;
	@Resource
	private IContentService contentService;
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		List<IMenu> menus = menuService.getTopMenus();
		model.addAttribute("topMenus",menus);
		model.addAttribute("contents",contentService.getLatest());
		return "index";
	}
	@RequestMapping(value ="/menuList.json", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<IMenu> getMenuList() {
	     return menuService.getTopMenus();
    }
	@RequestMapping("/lastContents.json")
    public @ResponseBody List<IContent> getNewContents() {
        return contentService.getLatest();
    }
	@ExceptionHandler(Exception.class)
	    public @ResponseBody String handleIOException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	System.out.println("handling1: unexpected error: " + ex.getLocalizedMessage());
	    	response.setHeader("Content-Type", "application/json");
	    	response.sendError(503, "" + ex.getLocalizedMessage());
	    	System.out.println("handling2: RETURNING: unexpected error: " + ex.getLocalizedMessage());
	    	return "unexpected error: " + ex.getLocalizedMessage();
	    }
	
}
