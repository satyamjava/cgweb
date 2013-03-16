package com.cgweb.domain;

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
@Table(name = "COMPANY_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
public class CompanyInfo {
	
		@Id()
		@Column(name = "COMPANY_SEQ")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "COMPANY_SEQ")
		@SequenceGenerator(name = "COMPANY_SEQ", sequenceName = "COMPANY_SEQ")
		private int id;
		
		@Column(name = "COMPANY_ID")
		private String companyId;

		@Column(name = "ESTABLISHMENT_YEAR")
		private String establishmentYear;

		@Column(name = "COMPANY_NAME")
		private String companyName;

		@Column(name = "WEBSITE")
		public String websiteAdd;
		
		@Column(name = "COMPANY_DESCRIPTION")
		public String companyDescription;
		
		@Column(name = "CONTACT_NUMBER")
		private String contactNumber;
		
		@Column(name = "email_id")
		private String emailId;
		
		@ManyToOne(cascade = CascadeType.ALL)
		private Address address;

		public CompanyInfo(String establishmentYear, String companyName, Address address)
		{
			this();
			this.establishmentYear = establishmentYear;
			this.companyName = companyName;
			this.address = address;
		}

		public CompanyInfo(String companyName)
		{
			this();
			this.companyName = companyName;
		}

		public CompanyInfo()
		{
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCompanyId() {
			return companyId;
		}

		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}

		public String getEstablishmentYear() {
			return establishmentYear;
		}

		public void setEstablishmentYear(String establishmentYear) {
			this.establishmentYear = establishmentYear;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getWebsiteAdd() {
			return websiteAdd;
		}

		public void setWebsiteAdd(String websiteAdd) {
			this.websiteAdd = websiteAdd;
		}

		public String getCompanyDescription() {
			return companyDescription;
		}

		public void setCompanyDescription(String companyDescription) {
			this.companyDescription = companyDescription;
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

}
