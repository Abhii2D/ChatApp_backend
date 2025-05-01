package com.chatapp.reqeust;

import java.time.LocalDateTime;

public class MessageRequest {

	
private String content;
private String sender;
private String roomid;
private LocalDateTime messagetime;
public MessageRequest(String content, String sender, String roomid, LocalDateTime messagetime) {
	super();
	this.content = content;
	this.sender = sender;
	this.roomid = roomid;
	this.messagetime = messagetime;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getRoomid() {
	return roomid;
}
public void setRoomid(String roomid) {
	this.roomid = roomid;
}
public LocalDateTime getMessagetime() {
	return messagetime;
}
public void setMessagetime(LocalDateTime messagetime) {
	this.messagetime = messagetime;
}
public MessageRequest() {
	super();
	// TODO Auto-generated constructor stub
}
}
