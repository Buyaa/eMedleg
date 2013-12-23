package com.mn.emedleg.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mn.emedleg.entity.CLoginInfo;
import com.mn.emedleg.entity.CUser;
import com.mn.emedleg.entity.IUser;
import com.mn.emedleg.entity.UserInfo;
import com.mn.emedleg.service.IUserService;


@Controller
//@RequestMapping("/login")
public class UserContoller {
	@Resource
	IUserService userService;
	@RequestMapping("/userAuthenticate")
    public @ResponseBody UserInfo getNewContents(HttpSession session,@RequestBody CLoginInfo user, HttpServletResponse response) {
		IUser cuser=userService.autenticate(user.getEmail(),user.getPassword());
		if(cuser!=null){
			//response.addCookie(new Cookie("SID", session.getId())); cookie bna
			return new UserInfo(cuser.getUserName(), cuser.getRegisteredDate(), cuser.isEnabled(), cuser.getRole());
		}
		response.setStatus(401);
        return null;
    }
}
