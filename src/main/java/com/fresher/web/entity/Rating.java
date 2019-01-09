package com.fresher.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "RATING")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Rating implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Id")
	private int id;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Stars")
	private int stars;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "CreatedOn")
	private Date createdOn;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "CreatedBy")
	private int createdBy;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "ChangedOn")
	private Date changedOn;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "ChangedBy")
	private int changedBy;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name= "ProductId", referencedColumnName = "Id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "Id")
	private User user;
	
	public Rating() {
		// TODO Auto-generated constructor stub
	}
	
	public Rating(int id, int stars, Date createdOn, int createdBy, Date changedOn, int changedBy) {
		this.id = id;
		this.stars = stars;
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

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
