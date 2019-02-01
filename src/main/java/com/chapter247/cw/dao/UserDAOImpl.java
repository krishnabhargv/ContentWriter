package com.chapter247.cw.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chapter247.cw.model.Content;
import com.chapter247.cw.model.History;
import com.chapter247.cw.model.Role;
import com.chapter247.cw.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, User Details="+p);
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = session.createQuery("from User").list();
		for(User p : personsList){
			logger.info("User List::"+p);
		}
		return personsList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+p);
		return p;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.get(User.class, new Integer(id));
		System.out.println("id-"+id);
		if(null != p){
			session.delete(p);
		}
		logger.info("User deleted successfully, person details="+p);
	}

	@Override
	public List<User> getUserByUsername(String user_name) {
		Session session = sessionFactory.getCurrentSession();
		User user=null;
		Query query= session.createQuery("from User where username='"+user_name+"'");
		List<User> userList=query.list();
		return userList;
	}

	@Override
	public Role getRoleById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Role role = (Role) session.load(Role.class, new Integer(id));
		logger.info("Role loaded successfully, User details="+role);
		return role;
	}

	@Override
	public void addContent(Content content) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(content);
		logger.info("content saved successfully, content Details="+content);
		
	}

	@Override
	public void updateContent(Content content) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(content);
		logger.info("content updated successfully, content Details="+content);
		
	}
	@Override
	public List<Content> getContentByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		//User p = (User) session.load(User.class, new Integer(id));
		//logger.info("User loaded successfully, User details="+p);
		Content Content=null;
		Query query= session.createQuery("from Content where user="+id);
		List<Content> contentList=query.list();
		System.out.println(contentList.size());
		
		return contentList;
	}

	@Override
	public void removeContent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Content content = (Content) session.load(Content.class, new Integer(id));
		History his =new History();
		his.setContent_id(content.getId());
		his.setRemark("Delete");
		his.setUpdated_content(content.getContent());
		his.setUser(content.getUser());
		session.persist(his);
		
		if(null != content){
			session.delete(content);
		}
		logger.info("content deleted successfully, content details="+content);
		
	}

	@Override
	public Content getContentrById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Content content = (Content) session.get(Content.class, new Integer(id));
		logger.info("Content loaded successfully, Content details="+content);
		return content;
	}

	@Override
	public List<Content> listContents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Content> contentList = session.createQuery("from Content").list();
		for(Content content : contentList){
			logger.info("Content 144 List::"+content);
		}
		return contentList;
	}

	@Override
	public void addHistory(History his) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(his);
		logger.info("User saved successfully, User Details="+his);
		
	}

	@Override
	public List<History> getHistoryByContentId(int id) {
		Session session = sessionFactory.getCurrentSession();
		History his=null;
		Query query= session.createQuery("from History where content_id="+id);
		List<History> hisList=query.list();
		logger.info("History loaded successfully.");
		
		return hisList;
	}

	@Override
	public List<History> getHistoryByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		History his=null;
		Query query= session.createQuery("from History where user="+id);
		List<History> hisList=query.list();
		logger.info("History loaded successfully.");
		return hisList;
	}
}
