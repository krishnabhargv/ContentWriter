package com.chapter247.cw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author Krishna Bhargava
*
*/
@Entity
@Table(name="content")
public class Content {
	
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the user
	 */
	
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[id=" + id + ", content=" + content + ", user=" + user.getName() + "]";
	}
	
	public String listToString(List<Content> contentList)
	{
	StringBuilder sb=new StringBuilder();	
	sb.append("Content {");
		for (Content content : contentList) {
			sb.append(content.toString());
		}
		sb.append("}");
		return sb.toString();
	}
	
	

	
}
