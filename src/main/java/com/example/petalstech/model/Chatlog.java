package com.example.petalstech.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class Chatlog 
{
	@Id
	@GeneratedValue
	private Long msgId;    // message_id
	
	
	private String user;   // name of user
	private String message;
	private boolean isSent;
	
//	@Basic
//	@Column(insertable = false, updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private LocalDateTime timeStamp;    // timestamp taken from system time

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSent() {
		return isSent;
	}

	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}

