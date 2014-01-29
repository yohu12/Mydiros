package com.diros.model;

import java.util.Date;

import com.diros.util.TimeConvert;

public class FastThought {

	private int id;
	private String thoughtTitle;
	private User user;
	private String createDt;
	private String lastMdyDt;
	private String replyDt;
	private int status;
	private String context;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThoughtTitle() {
		return thoughtTitle;
	}
	public void setThoughtTitle(String thoughtTitle) {
		this.thoughtTitle = thoughtTitle;
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = TimeConvert.timeToString(createDt);
	}
	public String getLastMdyDt() {
		return lastMdyDt;
	}
	public void setLastMdyDt(Date lastMdyDt) {
		this.lastMdyDt = TimeConvert.timeToString(lastMdyDt);
	}
	public String getReplyDt() {
		return replyDt;
	}
	public void setReplyDt(Date replyDt) {
		this.replyDt = TimeConvert.timeToString(replyDt);
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
}
