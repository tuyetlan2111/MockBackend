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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ARTIST")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Artist implements Serializable {
	
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
	@Column(name = "FirstName", columnDefinition="NVARCHAR(30)")
	private String firstName;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "LastName", columnDefinition="NVARCHAR(30)")
	private String lastName;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "LifeSpan", columnDefinition="NVARCHAR(35)")
	private String lifeSpan;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Country", columnDefinition="NVARCHAR(30)")
	private String country;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Description", columnDefinition="NVARCHAR(500)")
	private String description;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "TotalProducts")
	private int totalProducts;
	
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
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="artist")
	private Collection<Product> productCollection;
	
	public Artist() {
		// TODO Auto-generated constructor stub
	}
	
	public Artist(int id, String firstName, String lastName, String lifeSpan, String country, String description, int totalProducts, Date createdOn, int createdBy, Date changedOn, int changedBy) {
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.lifeSpan = lifeSpan;
		this.country = country;
		this.description = description;
		this.totalProducts = totalProducts;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
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

	public Collection<Product> getProductCollection() {
		return productCollection;
	}

	public void setProductCollection(Collection<Product> productCollection) {
		this.productCollection = productCollection;
	}
	
	
}
