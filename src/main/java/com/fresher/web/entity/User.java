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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "USER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

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
	@Column(name = "FirstName", columnDefinition = "NVARCHAR(30)")
	private String firstName;

	@Basic
	@NotBlank
	@NotNull
	@Column(name = "LastName", columnDefinition = "NVARCHAR(30)")
	private String lastName;

	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Email", columnDefinition = "NVARCHAR(100)")
	private String email;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Password", columnDefinition = "NVARCHAR(30)")
	private String password;

	@Basic
	@NotBlank
	@NotNull
	@Column(name = "City", columnDefinition = "NVARCHAR(30)")
	private String city;

	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Country", columnDefinition = "NVARCHAR(30)")
	private String country;

	@Basic
	@NotBlank
	@NotNull
	@Column(name = "SignupDate")
	private Date signupDate;

	@Basic
	@NotBlank
	@NotNull
	@Column(name = "OrderCount")
	private int orderCount;
	
	@Basic
	@NotBlank
	@NotNull
	@Column(name = "Role")
	private int role;

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
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<Order> orderCollection;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<Rating> ratingCollection;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password) {
	    this.email = email;
	    this.password = password;
	  }

	public User(int id, String firstName, String lastName, String email, String city, String country, Date signupDate,
			int orderCount, Date createdOn, int createdBy, Date changedOn, int changedBy) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.country = country;
		this.signupDate = signupDate;
		this.orderCount = orderCount;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public Collection<Order> getOrderCollection() {
		return orderCollection;
	}

	public void setOrderCollection(Collection<Order> orderCollection) {
		this.orderCollection = orderCollection;
	}

	public Collection<Rating> getRatingCollection() {
		return ratingCollection;
	}

	public void setRatingCollection(Collection<Rating> ratingCollection) {
		this.ratingCollection = ratingCollection;
	}
}
