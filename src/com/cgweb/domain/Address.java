package com.cgweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id()
		@Column(name = "ADDRESS_ID")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "ADDRESS_ID")
		@SequenceGenerator(name = "ADDRESS_ID", sequenceName = "ADDRESS_ID")
		private String id;

		@Column(name = "ADDRESS_LINE1")
		private String addressLine1;
		
		@Column(name = "ADDRESS_LINE2")
		private String addressLine2;
		
		@Column(name = "CITY")
		private String city;

		@Column(name = "STREET")
		private String street;
		
		@Column(name = "PHONE")
		private String phone;
		
		@Column(name = "FAX")
		private String fax;

		@Column(name = "STATE")
		private String state;
		
		@Column(name = "ZIP")
		private String zip;
		
		public Address(String address_line1, String city, String state)
		{
			this();
			this.addressLine1 = addressLine1;
			this.city = city;
			this.state = state;
		}

		public Address(String addressLine1)
		{
			this();
			this.addressLine1 = addressLine1;
		}

		public Address()
		{
			super();
		}

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getFax() {
			return fax;
		}

		public void setFax(String fax) {
			this.fax = fax;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}
}
