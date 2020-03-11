package local.tszolny.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private long id;
	private String locality;
	private String zipCode;
	private String street;
	private double streetNumber;

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public double getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(double streetNumber) {
		this.streetNumber = streetNumber;
	}

	public long getId() {
		return id;
	}
}
