package com.diros.model;

public class Forum {

	private int id;// 主键
	private int rId;// 父节点
	private String fName;// 板块名称
	private int state;// 状态
	private String fRemark; //备注
	private String fType;//板块类型
	private String fCode;//板块代码
	private int fLevel;//板块级别
	
	//扩展字段
	private String checkType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getfRemark() {
		return fRemark;
	}

	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public int getfLevel() {
		return fLevel;
	}

	public void setfLevel(int fLevel) {
		this.fLevel = fLevel;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	@Override
	public String toString() {
		return "Forum [id=" + id + ", rId=" + rId + ", fName=" + fName
				+ ", state=" + state + ", fRemark=" + fRemark + ", fType="
				+ fType + ", fCode=" + fCode + ", fLevel=" + fLevel
				+ ", checkType=" + checkType + "]";
	}
	
	
	
	

}
