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
	@NotBlank
	@NotNull
	@Column(name = "Id")
	private int id;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Title", columnDefinition = "NVARCHAR(100)")
	private String title;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Description", columnDefinition = "NVARCHAR(250)")
	private String description;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Image", columnDefinition = "NVARCHAR(30)")
	private String image;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Price")
	private float price;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "QuantitySold")
	private int quantitySold;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "AvgStars")
	private float avgStars;

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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "product")
	private Collection<OrderDetail> orderDetailCollection;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ArtistId", referencedColumnName="Id")
	private Artist artist;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String title, String description, String image, float price, int quantitySold, float avgStars, Date createdOn, int createdBy, Date changedOn, int changedBy) {
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

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
