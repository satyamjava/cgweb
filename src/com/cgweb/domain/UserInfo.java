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
@Table(name = "USER_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id()
		@Column(name = "USER_ID")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ID")
		@SequenceGenerator(name = "USER_ID", sequenceName = "USER_ID")
		private String id;

		@Column(name = "FIRST_NAME")
		private String firstName;
		
		@Column(name = "MIDDLE_NAME")
		private String middleName;
		
		@Column(name = "LAST_NAME")
		private String lastName;

		@Column(name = "PRIMARY_CONTACT_NUMBER")
		private long primaryContactNumber;
		
		@Column(name = "SECONDRY_CONTACT_NUMBER")
		private long secondryContactNumber;
		
		@Column(name = "CONTACT_NUMBER")
		private long contactNumber;

		@Column(name = "email_id")
		private String emailId;
		
		@Column(name = "designation")
		private String designation;
		
		@Column(name = "gender")
		private char gender;
		
		@Column(name = "contact_list_id")
		private String contactListId;
		
		@Column(name = "ADDRESS_ID")
		private String addressId;

		public UserInfo(String firstName, String lastName, long primaryContactNumber)
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

		public UserInfo()
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

		public String getAddressId() {
			return addressId;
		}

		public void setAddressId(String addressId) {
			this.addressId = addressId;
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

		public long getPrimaryContactNumber() {
			return primaryContactNumber;
		}

		public void setPrimaryContactNumber(long primaryContactNumber) {
			this.primaryContactNumber = primaryContactNumber;
		}

		public long getSecondryContactNumber() {
			return secondryContactNumber;
		}

		public void setSecondryContactNumber(long secondryContactNumber) {
			this.secondryContactNumber = secondryContactNumber;
		}

		public long getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(long contactNumber) {
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

		public char getGender() {
			return gender;
		}

		public void setGender(char gender) {
			this.gender = gender;
		}

		public String getContactListId() {
			return contactListId;
		}

		public void setContactListId(String contactListId) {
			this.contactListId = contactListId;
		}
}
