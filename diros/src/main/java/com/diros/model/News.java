package com.diros.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * 类名：News    
 * 功能：新闻实体类
 * @return：
 * @version：1.0 
 * author： tan
 * @date：2013-7-31
 */
public class News {
		
	private  int id;
	private  String title; //新闻标题
	private String content;//新闻内容
	private String createTime;//新闻创建时间
	private int userId;//发表新闻的用户的id
	private String replayTime;//最新的回复时间
	private int state;//状态
	private ArrayList<Tag> tags; //标签
	
	/**
	 * 以下是扩展字段
	 */
	private int comCount;//评论的条数

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	/**
	 * 
	 * 功能：从数据库获取时间，并转换成指定格式的时间显示
	 * @param createTime
	 * author tan
	 * date 2013-7-31
	 */
	public void setCreateTime(Date createTime) {
		System.out.println("createTime"+createTime);
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		this.createTime = sdFormat.format(createTime);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(String replayTime) {
		this.replayTime = replayTime;
	}
	public void setReplayTime(Date replayTime) {
		System.out.println(replayTime);
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		this.replayTime =  sdFormat.format(replayTime);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getComCount() {
		return comCount;
	}

	public void setComCount(int comCount) {
		this.comCount = comCount;
	}
	
	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", createTime=" + createTime + ", userId=" + userId
				+ ", replayTime=" + replayTime + ", state=" + state
				+ ", comCount=" + comCount + "]";
	}

	

	
	
	
}
