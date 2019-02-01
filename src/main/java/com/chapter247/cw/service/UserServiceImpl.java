package com.chapter247.cw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chapter247.cw.dao.UserDAO;
import com.chapter247.cw.model.Content;
import com.chapter247.cw.model.History;
import com.chapter247.cw.model.Role;
import com.chapter247.cw.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User p) {
		this.userDAO.addUser(p);
	}

	@Override
	@Transactional
	public void updateUser(User p) {
		this.userDAO.updateUser(p);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public Role getRoleById(int id) {
		return this.userDAO.getRoleById(id);
	}

	@Override
	@Transactional
	public void addContent(Content content) {
		 this.userDAO.addContent(content);
		
	}

	@Override
	@Transactional
	public void updateContent(Content content) {
		 this.userDAO.updateContent(content);
		
	}

	@Override
	@Transactional
	public List<Content> getContentByUserId(int id) {
		return this.userDAO.getContentByUserId(id);
	}

	@Override
	@Transactional
	public void removeContent(int id) {
		this.userDAO.removeContent(id);
		
	}

	@Override
	@Transactional
	public Content getContentrById(int id) {
		return this.userDAO.getContentrById(id);
	}

	@Override
	@Transactional
	public List<Content> listContents() {
		
		return this.userDAO.listContents();
	}

	@Override
	@Transactional
	public void addHistory(History his) {
		this.userDAO.addHistory(his);
		
	}

	@Override
	@Transactional
	public List<History> getHistoryByContentId(int id) {
		return this.userDAO.getHistoryByContentId(id);
	}

	@Override
	@Transactional
	public List<History> getHistoryByUserId(int id) {
		return this.userDAO.getHistoryByUserId(id);
	}

	@Override
	@Transactional
	public User getUSer(String username, String password) {
		boolean isValid=false;
		User validUser=null;
		List<User> userList=this.userDAO.getUserByUsername(username);
		if(!userList.isEmpty() && userList!=null)
		{
			for (User user : userList) {
				if(user.getPassword().equals(password))
					validUser=user;
				break;
				
			}
		}
		
		return validUser;
	}

}
