package com.chapter247.cw.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chapter247.cw.dao.UserDAOImpl;
import com.chapter247.cw.model.History;
import com.chapter247.cw.model.Role;
import com.chapter247.cw.model.User;
import com.chapter247.cw.service.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUsers(Model model) {
		System.out.println("listUsers called..43");
		logger.info("using logger------43 line ");
		return "home";
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "register";
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(HttpSession session, Model model) {
    System.out.println("inside userList");
	int userId=(Integer)session.getAttribute("userId");
	if(userId==8) //for this is hardcoded for admin role
	{
		model.addAttribute("listUsers", this.userService.listUsers());
		return "userList";
	}
	
	else
		return "home";
	}
	
	//For add and update user both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user){
		
		Role role=this.userService.getRoleById(2); // 2 is id of USER_ROLE, for now this is hardcoded
		 Set<Role> roles = new HashSet<Role>();  
		roles.add(role);
		user.setRoles(roles);
		
		if(user.getId() == 0){
			//new user, add it
			this.userService.addUser(user);
		}else{
			//existing user, call update
			this.userService.updateUser(user);
		}
		
		return "home";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.removeUser(id);
        return "register";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "register";
    }
	
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		System.out.println("login called ");
		return "login";
	}
    
    @RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
   	public String loginSubmit(HttpServletRequest request,HttpSession session, Model model) {
    	
   		String username=request.getParameter("username");
   		String password=request.getParameter("password");
    	System.out.println("loginsubmit called : username-"+username+", password - "+password);
    	User user=this.userService.getUSer(username, password);
    	if(user!=null)
    	{
    		session.setAttribute("userId", user.getId());
    		session.setAttribute("currentuser", user);
    		return "home";
    	}
    	else{
    		model.addAttribute("msg", "Invalid User");
    		return "login";
    	}
    		
   	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpSession session, Model model) {
        session.invalidate();  
		return "home";
	}
	
	
	
}
