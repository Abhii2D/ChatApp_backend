package com.chatapp.entity;

import java.time.LocalDateTime;

public class Message {
	
	private String sender;
	
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	private String content;
	private LocalDateTime timestamp;
	
	
	public Message( String sender,String content) {
		this.content = content;
		this.sender = sender;
		this.timestamp = LocalDateTime.now();
	}
	
	

}
