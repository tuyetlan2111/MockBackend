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
@Table(name = "CARTITEM")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CartItem implements Serializable{
	
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
	@Column(name = "ProductId")
	private int productId;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Price")
	private float price;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Quantity")
	private int quantity;
	
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
	@JoinColumn(name = "CartId", referencedColumnName="Id")
	private Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
