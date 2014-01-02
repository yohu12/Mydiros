package com.diros.model;

public class Message {
	private int messageId;
	private int groupId;
	private String msgTitle;
	private User fromUser;
	private User toUser;
	private String content;
	private String sendDt;
	
	
	public int getMessageId() {
		return messageId;
	}



	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}



	public int getGroupId() {
		return groupId;
	}



	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}



	public String getMsgTitle() {
		return msgTitle;
	}



	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public User getFromUser() {
		return fromUser;
	}



	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}




	public User getToUser() {
		return toUser;
	}



	public void setToUser(User toUser) {
		this.toUser = toUser;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getSendDt() {
		return sendDt;
	}



	public void setSendDt(String sendDt) {
		this.sendDt = sendDt;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", groupId=" + groupId
				+ ", msgTitle=" + msgTitle + ", fromUser=[" + fromUser.toString()
				+ "], toUser=[" + toUser.toString() + "], content=" + content
				+ ", sendDt=" + sendDt + "]";
	}
	
	
	
}
