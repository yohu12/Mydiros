package com.diros.model;

import java.util.Date;

/**
 * 类名:User
 * 功能：用户实体表
 * @author tan
 *
 */
public class User {
	
	private int userId; //用户id
	
	private String name;//登录名
	
	private String pword;
	
	private Date regiestDt;//注册时间
	
	private Date lastLoginDt;//最后登录时间
	
	private String nickName;//昵称
	
	private String location;//所在地
	
	private int level; //级别
	
	private int fansCount;//粉丝数量
	
	private String photo ;//头像
	
	private String sex;//性别
	
	private String email;//电子邮箱
	
	private int state;//状态

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public Date getRegiestDt() {
		return regiestDt;
	}

	public void setRegiestDt(Date regiestDt) {
		this.regiestDt = regiestDt;
	}

	public Date getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(Date lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", pword=" + pword
				+ ", regiestDt=" + regiestDt + ", lastLoginDt=" + lastLoginDt
				+ ", nickName=" + nickName + ", location=" + location
				+ ", level=" + level + ", fansCount=" + fansCount + ", photo="
				+ photo + ", sex=" + sex + ", email=" + email + ", state="
				+ state + "]";
	}

	
	
		
}
