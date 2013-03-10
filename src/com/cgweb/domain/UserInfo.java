package com.cgweb.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id()
		@Column(name = "USER_ID")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ID")
		@SequenceGenerator(name = "USER_ID", sequenceName = "USER_ID")
		private int id;

		@Column(name = "FIRST_NAME")
		private String firstName;
		
		@Column(name = "MIDDLE_NAME")
		private String middleName;
		
		@Column(name = "LAST_NAME")
		private String lastName;

		@Column(name = "PRIMARY_CONTACT_NUMBER")
		private String primaryContactNumber;
		
		@Column(name = "SECONDARY_CONTACT_NUMBER")
		private String secondaryContactNumber;
		
		@Column(name = "CONTACT_NUMBER")
		private String contactNumber;

		@Column(name = "email_id")
		private String emailId;
		
		@Column(name = "designation")
		private String designation;
		
		@Column(name = "gender")
		private String gender;
		
		@Column(name = "contact_list_id")
		private String contactListId;
		
		//@Column(name = "ADDRESS_ID")
		@ManyToOne(cascade = CascadeType.ALL)
		private Address address;

		public UserInfo(String firstName, String lastName, String primaryContactNumber)
		{
			this();
			this.firstName = firstName;
			this.lastName = lastName;
			this.primaryContactNumber = primaryContactNumber;
		}

		public UserInfo(String firstName)
		{
			this();
			this.firstName = firstName;
		}
		
		public UserInfo(Address address)
		{
			this.address = address;
		}

		public UserInfo()
		{
			super();
		}

		public int getId()
		{
			return id;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPrimaryContactNumber() {
			return primaryContactNumber;
		}

		public void setPrimaryContactNumber(String primaryContactNumber) {
			this.primaryContactNumber = primaryContactNumber;
		}

		public String getSecondaryContactNumber() {
			return secondaryContactNumber;
		}

		public void setSecondaryContactNumber(String secondaryContactNumber) {
			this.secondaryContactNumber = secondaryContactNumber;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getContactListId() {
			return contactListId;
		}

		public void setContactListId(String contactListId) {
			this.contactListId = contactListId;
		}
}
