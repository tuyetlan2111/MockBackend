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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ORDERPRODUCT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@NotNull
	@Column(name = "Id")
	private int id;

	@Basic
	@NotNull
	@Column(name = "OrderDate")
	private Date orderDate;

	@Basic
	@NotNull
	@Column(name = "TotalPrice")
	private float totalPrice;

	@Basic
	@NotNull
	@Column(name = "OrderNumber")
	private int orderNumber;

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
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "orderProduct")
	private Collection<OrderDetail> orderDetailCollection;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "Id")
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Payment payment) {
		this.orderDate = payment.getCreatedOn();
		this.createdOn = payment.getCreatedOn();
		this.createdBy = payment.getCreatedBy();
		this.changedOn = payment.getChangedOn();
		this.changedBy = payment.getChangedBy();
		this.totalPrice = payment.getTotalPrice();
		this.orderNumber = payment.getOrder().getOrderNumber();
		this.user = payment.getUser();

	}
	
	public Order(@NotNull int id, @NotNull Date orderDate, @NotNull float totalPrice, @NotNull int orderNumber,
			@NotNull int itemCount, @NotNull Date createdOn, @NotNull int createdBy, @NotNull Date changedOn,
			@NotNull int changedBy, Collection<OrderDetail> orderDetailCollection, User user) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.orderNumber = orderNumber;
		this.itemCount = itemCount;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.changedOn = changedOn;
		this.changedBy = changedBy;
		this.orderDetailCollection = orderDetailCollection;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
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

	public Collection<OrderDetail> getOrderDetailCollection() {
		return orderDetailCollection;
	}

	public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
		this.orderDetailCollection = orderDetailCollection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", orderNumber="
				+ orderNumber + ", itemCount=" + itemCount + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", changedOn=" + changedOn + ", changedBy=" + changedBy + ", orderDetailCollection="
				+ orderDetailCollection + ", user=" + user + "]";
	}

}
