package com.chapter247.cw.dao;

import java.util.List;

import com.chapter247.cw.model.Content;
import com.chapter247.cw.model.History;
import com.chapter247.cw.model.Role;
import com.chapter247.cw.model.User;

public interface UserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
	public List<User> getUserByUsername(String username);
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
