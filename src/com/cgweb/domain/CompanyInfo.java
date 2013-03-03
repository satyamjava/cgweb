package com.cgweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CompanyInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id()
		@Column(name = "COMPANY_ID")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "COMPANY_ID")
		@SequenceGenerator(name = "COMPANY_ID", sequenceName = "COMPANY_ID")
		private String id;

		@Column(name = "ESTABLISHMENT_YEAR")
		private String establishmentYear;

		@Column(name = "COMPANY_NAME")
		private String companyName;

		@Column(name = "ADDRESS_ID")
		private Address addressId;

		public CompanyInfo(String establishmentYear, String companyName, Address addressId)
		{
			this();
			this.establishmentYear = establishmentYear;
			this.companyName = companyName;
			this.addressId = addressId;
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

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
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

		public Address getAddressId() {
			return addressId;
		}

		public void setAddressId(Address addressId) {
			this.addressId = addressId;
		}
}
