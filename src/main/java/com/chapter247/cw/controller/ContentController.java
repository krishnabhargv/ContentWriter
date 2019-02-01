package com.chapter247.cw.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.chapter247.cw.model.Content;
import com.chapter247.cw.model.History;
import com.chapter247.cw.model.Role;
import com.chapter247.cw.model.User;
import com.chapter247.cw.service.UserService;

@Controller
public class ContentController {
	
private UserService userService;
	

   HttpRequest request;
 
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	
	@RequestMapping(value = "/writeContent", method = RequestMethod.GET)
	public String writeContent(HttpSession session, Model model) {
		System.out.println("Called writeContent");
		int userId=(Integer) session.getAttribute("userId");
		model.addAttribute("content", new Content());
	    model.addAttribute("listContents", this.userService.getContentByUserId(userId));
	    System.out.println("after list");
		return "content";
	}
	
	//For add and update user both
		@RequestMapping(value= "/addContent", method = RequestMethod.POST)
		public String addUser(@ModelAttribute("content") Content content, Model model, HttpSession session){
			
			int userId=(Integer) session.getAttribute("userId");
			User user=this.userService.getUserById(userId);
			content.setUser(user);
			History his=new History();
			his.setUpdated_content(content.getContent());
			his.setUser(content.getUser());
			
			if(content.getId() == 0){
				//new user, add it
				this.userService.addContent(content);
				his.setRemark("New");
				his.setContent_id(content.getId());
				this.userService.addHistory(his);
			}else{
				//existing content, call update
				this.userService.updateContent(content);
				his.setContent_id(content.getId());
				his.setRemark("Update");
				this.userService.addHistory(his);
				
			}
			
			 model.addAttribute("content", new Content());
			 model.addAttribute("listContents", this.userService.getContentByUserId(userId));
			return "content";
			
		}
		
		
		@RequestMapping("/removeContent/{id}")
	    public String removeContent(@PathVariable("id") int id, Model model, HttpSession session){
			int userId=(Integer) session.getAttribute("userId");
	        this.userService.removeContent(id);
	        model.addAttribute("content", new Content());
		    model.addAttribute("listContents", this.userService.getContentByUserId(userId));
	        return "content";
	    }
	 
	    @RequestMapping("/editContent/{id}")
	    public String editContent(@PathVariable("id") int id, Model model, HttpSession session){
	    	int userId=(Integer) session.getAttribute("userId");
	        model.addAttribute("content", this.userService.getContentrById(id));
	        model.addAttribute("listContents", this.userService.getContentByUserId(userId));
	        System.out.println("Returning for edit");
	        return "content";
	    }
	    
	    @RequestMapping("/history/{id}")
	    public String getHistory(@PathVariable("id") int id, Model model){
			
		    model.addAttribute("listHistory", this.userService.getHistoryByContentId(id));
	        return "history";
	    }
	    
	    @RequestMapping("/allHistory")
	    public String allHistory(Model model, HttpSession session){
	    	int userId=(Integer) session.getAttribute("userId");
		    model.addAttribute("listHistory", this.userService.getHistoryByUserId(userId));
	        return "history";
	    }
		
	    @RequestMapping(value = "/getContentById/{id}", method = RequestMethod.GET)
		public  @ResponseBody String getContentById(@PathVariable("id") int id, Model model) {
			System.out.println("Called writeContent");
			model.addAttribute("content", new Content());
		  Content content=this.userService.getContentrById(id);
		    System.out.println("after list---"+content);
			if(content==null)
				return "No content found";
			else
		      return content.toString();
		}
	    
	    @RequestMapping(value = "/getContentByUserId/{id}", method = RequestMethod.GET)
		public  @ResponseBody String getContentByUserId(@PathVariable("id") int id, Model model) throws JsonGenerationException, JsonMappingException, IOException {
			System.out.println("Called writeContent");
			
			
			model.addAttribute("content", new Content());
		  List<Content> contentList=this.userService.getContentByUserId(id);
		    
		  if(contentList.isEmpty())
			  return "No content found";
		  else
		  return new Content().listToString(contentList);
		
		}
	    
	    @RequestMapping(value = "/getAllContent", method = RequestMethod.GET)
		public  @ResponseBody String getAllContent(Model model) {
			System.out.println("Called writeContent");
			
			 List<Content> contentList=this.userService.listContents();
		    if(contentList.isEmpty())
		    	return "No content found";
		    else
			 return new Content().listToString(contentList);
		}
		

}
