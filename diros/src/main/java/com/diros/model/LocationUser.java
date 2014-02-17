package com.diros.model;

public class LocationUser {
	
	private int id;
	private int locId;//location的id
	private int userId;//user的id
	private int isInterested; //是否感兴趣
	private int isJoin;//是否加入
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsInterested() {
		return isInterested;
	}
	public void setIsInterested(int isInterested) {
		this.isInterested = isInterested;
	}
	public int getIsJoin() {
		return isJoin;
	}
	public void setIsJoin(int isJoin) {
		this.isJoin = isJoin;
	}
	@Override
	public String toString() {
		return "LocationUser [id=" + id + ", locId=" + locId + ", userId="
				+ userId + ", isInterested=" + isInterested + ", isJoin="
				+ isJoin + "]";
	}
	

	
	
	
	
	
}
