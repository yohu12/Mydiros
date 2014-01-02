package com.diros.model;

/**
 * 
 * 类名：EditData    
 * 功能：接收从前台编辑框提交的数据
 * @return：
 * @version：1.0 
 * author： tan
 * @date：2013-8-1
 */
public class EditData {
	
	private int id;
	private String title;
	private String context;
	private int forum;
	private String code;
	
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
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getForum() {
		return forum;
	}
	public void setForum(int forum) {
		this.forum = forum;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", context=" + context
				+ ", forum=" + forum + ", code=" + code + "]";
	}
}
