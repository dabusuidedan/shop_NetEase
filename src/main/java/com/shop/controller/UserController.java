package com.shop.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.util.MD5;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserDao userDao;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpSession session) {
    	System.out.println(model.getUserName());
        User user = userDao.findByUsername(model.getUserName());
        String psd=MD5.md5Password(user.getUserPassword());
        if (user == null || !psd.equals(model.getUserPassword())) {
            return new ModelAndView("redirect:../freemarker/login.ftl");
        } else if(user.getUserName().equals("buyer")){
            session.setAttribute("user", user);
            ModelAndView mv = new ModelAndView("redirect:/home/shouye.action");
            return mv;
        }
        else {
        	session.setAttribute("user", user);
            ModelAndView mv = new ModelAndView("redirect:/home/shouye.action");
            return mv;
        }
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
    	if(session.getAttribute("user")!=null) {
    		session.removeAttribute("user");
    	}
            ModelAndView mv = new ModelAndView("redirect:/home/shouye.action");
            return mv;
    }
}