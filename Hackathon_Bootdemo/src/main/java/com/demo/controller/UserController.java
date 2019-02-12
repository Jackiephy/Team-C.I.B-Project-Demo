package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.domain.User;
import com.demo.service.UserService;

@Controller
public class UserController {
	
	/**
	 * welcome index
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
		
	}
	
	/**
	 * index
	 * @return
	 */
	@RequestMapping("/index")
	public String index1() {
		return "index";
		
	}
	
	@Autowired
	private UserService userservice;
	/**
	 * login index
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
		
	}
	
	/**
	 * check login
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user=userservice.findByName(username);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return "index";
			}else {
				model.addAttribute("error", "wrong password");
	            return "login";		
			}
		}else {
			model.addAttribute("error", "wrong username");
			return "login";
		}    
    }
	
	@RequestMapping("/register")
	public String register() {
		return "register";	
	}
	
	
	@RequestMapping(value = "/checkregister", method = RequestMethod.POST)
    public String checkregister(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user=userservice.findByName(username);
		if(user == null) {
			User nuser = new User();
			nuser.setUsername(username);
			nuser.setPassword(password);
			userservice.add(nuser);
			return "login";
			
			
		}else {
			model.addAttribute("error", "this name is used, please try another name!!!");
			return "register";
		}    
    }
	
	

}
