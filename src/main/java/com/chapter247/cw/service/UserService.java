package com.chapter247.cw.service;

import java.util.List;

import com.chapter247.cw.model.Content;
import com.chapter247.cw.model.History;
import com.chapter247.cw.model.Role;
import com.chapter247.cw.model.User;

public interface UserService {

	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(int id);
	public User getUSer(String username, String password);
	public void removeUser(int id);
	public Role getRoleById(int id);
	
	
	
	//For Content
		public void addContent(Content content);
		public void updateContent(Content content);
		public List<Content> getContentByUserId(int id);
		public void removeContent(int id);
	
		public Content getContentrById(int id);
		public List<Content> listContents();
		public void addHistory(History his);
		public List<History> getHistoryByContentId(int id);
		public List<History> getHistoryByUserId(int id);
}
