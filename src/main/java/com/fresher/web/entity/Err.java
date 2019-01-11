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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ERROR")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Err implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@NotBlank
	@Column(name = "Id")
	private int id;

	@Basic
	@NotBlank
	@Column(name = "UserId")
	private int userId;

	@Basic
	@NotBlank
	@Column(name = "ErrorDate")
	private Date errorDate;

	@Basic
	@NotBlank
	@Column(name = "IpAddress", columnDefinition = "NVARCHAR(500)")
	private String ipAddress;

	@Basic
	@NotBlank
	@Column(name = "UserAgent", columnDefinition = "NVARCHAR(500)")
	private String userAgent;

	@Basic
	@NotBlank
	@Column(name = "Exception", columnDefinition = "NVARCHAR(500)")
	private String exception;

	@Basic
	@NotBlank
	@Column(name = "Message", columnDefinition = "NVARCHAR(500)")
	private String message;

	@Basic
	@NotBlank
	@Column(name = "Everything", columnDefinition = "NVARCHAR(500)")
	private String everything;

	@Basic
	@NotBlank
	@Column(name = "HttpReferer", columnDefinition = "NVARCHAR(500)")
	private String httpReferer;

	@Basic
	@NotBlank
	@Column(name = "PathAndQuery", columnDefinition = "NVARCHAR(500)")
	private String pathAndQuery;
	@Basic
	@NotBlank
	@Column(name = "CreatedOn")
	private Date createdOn;

	@Basic
	@NotBlank
	@Column(name = "CreatedBy")
	private int createdBy;

	@Basic
	@NotBlank
	@Column(name = "ChangedOn")
	private Date changedOn;

	@Basic
	@NotBlank
	@Column(name = "ChangedBy")
	private int changedBy;

	public Err() {
		// TODO Auto-generated constructor stub
	}

	public Err(int id, int userId, Date errorDate, String ipAddress, String userAgent, String exception, String message,
			String everything, String httpReferer, String pathAndQuery, Date createdOn, int createdBy, Date changedOn,
			int changedBy) {
		this.id = id;
		this.userId = userId;
		this.errorDate = errorDate;
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.exception = exception;
		this.message = message;
		this.everything = everything;
		this.httpReferer = httpReferer;
		this.pathAndQuery = pathAndQuery;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.changedOn = changedOn;
		this.changedBy = changedBy;
	}

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
