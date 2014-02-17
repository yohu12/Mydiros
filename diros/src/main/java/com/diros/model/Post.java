package com.diros.model;

public class Post {
	private int postId;
	private String postTitle;
	private String postContent;
	private String createDt;
	private String lostMdyDt;
	private User createUser;
	private int type;
	private int state;
	private Forum forum;		 
	
	private int commentCount;
	private int praiseCount;
	private int collectCount;

	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getLostMdyDt() {
		return lostMdyDt;
	}
	public void setLostMdyDt(String lostMdyDt) {
		this.lostMdyDt = lostMdyDt;
	}
	
	
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public int getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}
	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + ", createDt=" + createDt
				+ ", lostMdyDt=" + lostMdyDt + ", createUser=[" + createUser.toString()
				+ "], type=" + type + ", state="
				+ state + ", forumId=[" + forum.toString() + "], commentCount="
				+ commentCount + ", praiseCount=" + praiseCount
				+ ", collectCount=" + collectCount + "]";
	}
	
	
	
	

	
}
