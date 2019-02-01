package com.chapter247.cw.model;

import java.sql.Date;

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
@Table(name="history")
public class History {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="updated_content")
	private String updated_content;
	
	@Column(name="updated_date")
	private Date updated_date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	
	@Column(name = "content_id", nullable = false)
	private int content_id;

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
	 * @return the old_content
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param old_content the old_content to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the updated_content
	 */
	public String getUpdated_content() {
		return updated_content;
	}

	/**
	 * @param updated_content the updated_content to set
	 */
	public void setUpdated_content(String updated_content) {
		this.updated_content = updated_content;
	}

	/**
	 * @return the updated_date
	 */
	public Date getUpdated_date() {
		return updated_date;
	}

	/**
	 * @param updated_date the updated_date to set
	 */
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
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

	/**
	 * @return the content_id
	 */
	public int getContent_id() {
		return content_id;
	}

	/**
	 * @param content_id the content_id to set
	 */
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	
	
	

}
