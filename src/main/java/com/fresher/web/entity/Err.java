package com.fresher.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ERROR")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Err implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@NotNull
	@Column(name = "Id")
	private int id;
	
	@Basic
	@NotNull
	@Column(name = "UserId")
	private int userId;
	
	@Basic
	@NotNull
	@Column(name = "ErrorDate")
	private Date errorDate;
	
	@Basic
	@NotNull
	@Column(name = "IpAddress", columnDefinition = "NVARCHAR(MAX)")
	private String ipAddress;
	
	@Basic
	@NotNull
	@Column(name = "UserAgent", columnDefinition = "NVARCHAR(MAX)")
	private String userAgent;
	
	@Basic
	@NotNull
	@Column(name = "Exception", columnDefinition = "NVARCHAR(MAX)")
	private String exception;
	
	@Basic
	@NotNull
	@Column(name = "Message", columnDefinition = "NVARCHAR(MAX)")
	private String message;
	
	@Basic
	@NotNull
	@Column(name = "Everything", columnDefinition = "NVARCHAR(MAX)")
	private String everything;
	
	@Basic
	@NotNull
	@Column(name = "HttpReferer", columnDefinition = "NVARCHAR(500)")
	private String httpReferer;
	
	@Basic
	@NotNull
	@Column(name = "PathAndQuery", columnDefinition = "NVARCHAR(500)")
	private String pathAndQuery;
	@Basic
	@NotNull
	@Column(name = "CreatedOn")
	private Date createdOn;

	@Basic
	@NotNull
	@Column(name = "CreatedBy")
	private int createdBy;

	@Basic
	@NotNull
	@Column(name = "ChangedOn")
	private Date changedOn;

	@Basic
	@NotNull
	@Column(name = "ChangedBy")
	private int changedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getErrorDate() {
		return errorDate;
	}

	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEverything() {
		return everything;
	}

	public void setEverything(String everything) {
		this.everything = everything;
	}

	public String getHttpReferer() {
		return httpReferer;
	}

	public void setHttpReferer(String httpReferer) {
		this.httpReferer = httpReferer;
	}

	public String getPathAndQuery() {
		return pathAndQuery;
	}

	public void setPathAndQuery(String pathAndQuery) {
		this.pathAndQuery = pathAndQuery;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

	public int getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(int changedBy) {
		this.changedBy = changedBy;
	}
}
