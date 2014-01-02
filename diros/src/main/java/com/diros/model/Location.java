package com.diros.model;


public class Location {
	private int id; 
	private String title; //活动标题
	private int place;//活动地点
	private String startTime;//活动开始时间
	private String endTime;//活动结束时间
	private String detalis;//活动详情
	private String label;//活动标签
	private int initiator; //活动发起人id与用户表id相关联
	private int state;//状态 判断当前活动是否即将开始或已经结束
	private int type;//活动所属类型
	private String posterImg; //活动海报路径
	
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
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDetalis() {
		return detalis;
	}
	public void setDetalis(String detalis) {
		this.detalis = detalis;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getInitiator() {
		return initiator;
	}
	public void setInitiator(int initiator) {
		this.initiator = initiator;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPosterImg() {
		return posterImg;
	}
	public void setPosterImg(String posterImg) {
		this.posterImg = posterImg;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", title=" + title + ", place=" + place
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", detalis=" + detalis + ", label=" + label + ", initiator="
				+ initiator + ", state=" + state + ", type=" + type
				+ ", posterImg=" + posterImg + "]";
	}
	
	
	
	
	
	
}
