package com.corporate.gazetteer.object;

public class EmpCompClientStak {
			
	public String roll;	//OR Action----Employee, Company, Client, StackHolder
	public String mobileNo;
	public String phoneNo;
	public String faxNo;
	public String addressLineOne;
	public String addressLineTwo;
	public String city;
	public String state;
	public String zip;
	public String countryName;
	
	public EmpCompClientStak(String l_roll, String l_mobile, String l_phone, String l_fax, String l_add_1, String l_add_2, String l_city, String l_state, String l_zip, String l_country) {
		roll = l_roll;
		mobileNo = l_mobile;
		phoneNo = l_phone;
		faxNo = l_fax;
		addressLineOne = l_add_1;
		addressLineTwo = l_add_2;
		city = l_city;
		state = l_state;
		zip = l_zip;
		countryName = l_country;
	}
	
	public String getRoll() {
		return roll;
	}

	public void setRoll(String l_roll) {
		roll = l_roll;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String l_mobileNo) {
		mobileNo = l_mobileNo;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String l_phoneNo) {
		phoneNo = l_phoneNo;
	}
	
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String l_faxNo) {
		faxNo = l_faxNo;
	}
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String l_addressLineOne) {
		addressLineOne = l_addressLineOne;
	}
	
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	
	public void setAddressLineTwo(String l_addressLineTwo) {
		addressLineTwo = l_addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	
	public void setCity(String l_city) {
		city = l_city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String l_state) {
		state = l_state;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip(String l_zip) {
		zip = l_zip;
	}
	
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String l_countryName) {
		countryName = l_countryName;
	}

}
