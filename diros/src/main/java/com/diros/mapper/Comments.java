package com.diros.mapper;

import com.diros.model.User;

public class Comments {
	private int contentId;
	private int postId;
	private String content;
	private int fId;
	private String createDt;
	private User user;
	private int state;
	

	
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Comments [contentId=" + contentId + ", postId=" + postId
				+ ", content=" + content + ", fId=" + fId + ", createDt="
				+ createDt + ", user=[" + user.toString() +"], state=" + state + "]";
	}
	
	
	
	
}
