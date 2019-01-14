package com.fresher.web.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CART")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@NotNull
	@Column(name = "Id")
	private int id;

	@Basic
	@NotNull
	@Column(name = "Cookie", columnDefinition = "NVARCHAR(40)")
	private String cookie;

	@Basic
	@NotNull
	@Column(name = "CartDate")
	private Date cartDate;

	@Basic
	@NotNull
	@Column(name = "ItemCount")
	private int itemCount;

	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedOn", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdOn;

	@Basic
	@NotNull
	@Column(name = "CreatedBy")
	private int createdBy;

	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ChangedOn", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date changedOn;

	@Basic
	@NotNull
	@Column(name = "ChangedBy")
	private int changedBy;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cart")
	private Collection<CartItem> cartItemCollection;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(@NotNull int id, @NotNull String cookie, @NotNull Date cartDate, @NotNull int itemCount,
			@NotNull Date createdOn, @NotNull int createdBy, @NotNull Date changedOn, @NotNull int changedBy,
			Collection<CartItem> cartItemCollection) {
		super();
		this.id = id;
		this.cookie = cookie;
		this.cartDate = cartDate;
		this.itemCount = itemCount;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.changedOn = changedOn;
		this.changedBy = changedBy;
		this.cartItemCollection = cartItemCollection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
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

	public Collection<CartItem> getCartItemCollection() {
		return cartItemCollection;
	}

	public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
		this.cartItemCollection = cartItemCollection;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cookie=" + cookie + ", cartDate=" + cartDate + ", itemCount=" + itemCount
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", changedOn=" + changedOn + ", changedBy="
				+ changedBy + ", cartItemCollection=" + cartItemCollection + "]";
	}

}
