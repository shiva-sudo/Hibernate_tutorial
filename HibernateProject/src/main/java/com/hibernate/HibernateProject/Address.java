package com.hibernate.HibernateProject;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/* @Entity  --Mark this class as a Entity
 * @Table	--this will change the table name
 * @Id		--mark column as a primary key
 * @GeneratedValue --used for auto increment
 * @Column	--use to specify column name in database
 * @Temporal --Used for date formating which need to be saved in Db
 * @Lob 	--for storing the large object file in the database
 * 
 */

@Entity
@Table(name = "student_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(length = 50, name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "is_open")
	private boolean isopen;

	@Transient
	private double area;

	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	@Lob
	private byte[] image;

	public Address() {
		super();

		/*------------Constructor--------------*/

	}

	public Address(int addressId, String street, String city, boolean isopen, double area, Date addedDate,
			byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isopen = isopen;
		this.area = area;
		this.addedDate = addedDate;
		this.image = image;
	}

	/*------------Getter and Setter--------------*/

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isIsopen() {
		return isopen;
	}

	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
