package com.diros.model;

import java.util.Date;

/**
 * 
 * 类名：NewsComment    
 * 功能：新闻评论实体类
 * @return：
 * @version：1.0 
 * author： tan
 * @date：2013-7-31
 */
public class NewsComment {
		
	private int id;
	private int newsId;//评论的话题
	private String content;//评论内容
	private String createTime;//评论时间
	private int rootId;//根节点id，及评论的对象id
	private int userId;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "NewsComment [id=" + id + ", newsId=" + newsId + ", content="
				+ content + ", createTime=" + createTime + ", rootId=" + rootId
				+ ", userId=" + userId + ", state=" + state + "]";
	}

		
	
	
}
