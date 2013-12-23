package com.mn.emedleg.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.CLoginInfo;
import com.mn.emedleg.service.IUserService;


@Controller
//@RequestMapping("/login")
public class UserContoller {
	@Resource
	IUserService userService;
	@RequestMapping("/userAuthenticate")
    public @ResponseBody boolean getNewContents(HttpSession session, CLoginInfo user, HttpServletResponse response) {
		System.out.println("controller: "+user.getEmail()+" "+user.getPassword());
		if(userService.autenticate(user.getEmail(),user.getPassword())){
			
			response.addCookie(new Cookie("SID", session.getId()));
			return true;
		}
		response.setStatus(401);
        return false;
    }
}
