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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PRODUCT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@NotNull
	@Column(name = "Id")
	private int id;
	
	@Basic
	@NotNull
	@Column(name = "Title", columnDefinition = "NVARCHAR(100)")
	private String title;
	
	@Basic
	@NotNull
	@Column(name = "Description", columnDefinition = "NVARCHAR(250)")
	private String description;
	
	@Basic
	@NotNull
	@Column(name = "Image", columnDefinition = "NVARCHAR(30)")
	private String image;
	
	@Basic
	@NotNull
	@Column(name = "Price")
	private float price;
	
	@Basic
	@NotNull
	@Column(name = "QuantitySold")
	private int quantitySold;
	
	@Basic
	@NotNull
	@Column(name = "AvgStars")
	private float avgStars;

	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedOn", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdOn;
	
	@Basic
	@NotNull
	@Column(name = "CreatedBy")
	private int createdBy;
	
	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ChangedOn", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date changedOn;
	
	@Basic
	@NotNull
	@Column(name = "ChangedBy")
	private int changedBy;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "product")
	private Collection<OrderDetail> orderDetailCollection;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "product")
	private Collection<CartItem> cartItemCollection;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ArtistId", referencedColumnName="Id")
	private Artist artist;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(@NotBlank @NotNull int id, @NotBlank @NotNull String title, @NotBlank @NotNull String description,
			@NotBlank @NotNull String image, @NotBlank @NotNull float price, @NotBlank @NotNull int quantitySold,
			@NotBlank @NotNull float avgStars, @NotBlank @NotNull Date createdOn, @NotBlank @NotNull int createdBy,
			@NotBlank @NotNull Date changedOn, @NotBlank @NotNull int changedBy,
			Collection<OrderDetail> orderDetailCollection, Collection<CartItem> cartItemCollection, Artist artist) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantitySold = quantitySold;
		this.avgStars = avgStars;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.changedOn = changedOn;
		this.changedBy = changedBy;
		this.orderDetailCollection = orderDetailCollection;
		this.cartItemCollection = cartItemCollection;
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public float getAvgStars() {
		return avgStars;
	}

	public void setAvgStars(float avgStars) {
		this.avgStars = avgStars;
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

	public Collection<CartItem> getCartItemCollection() {
		return cartItemCollection;
	}

	public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
		this.cartItemCollection = cartItemCollection;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", price=" + price + ", quantitySold=" + quantitySold + ", avgStars=" + avgStars + ", createdOn="
				+ createdOn + ", createdBy=" + createdBy + ", changedOn=" + changedOn + ", changedBy=" + changedBy
				+ ", orderDetailCollection=" + orderDetailCollection + ", cartItemCollection=" + cartItemCollection
				+ ", artist=" + artist + "]";
	}
	
	
}
