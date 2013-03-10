package com.corporate.gazetteer.object;

public class Company extends EmpCompClientStak {
	
	public String companyID;
	public String companyName;
	public String websiteAdd;
	public String companyDescription;
		
	
	public Company(String l_cmp_id, String l_cmp_name, String l_cmp_website, String l_cmp_desc, String l_roll, String l_mobile, String l_phone, String l_fax, String l_add_1, String l_add_2, String l_city, String l_state, String l_zip, String l_country) {
		
		super(l_roll,l_mobile, l_phone,  l_fax,  l_add_1,  l_add_2,  l_city,  l_state,  l_zip,  l_country);
		
		companyID = l_cmp_id;
		companyName = l_cmp_name;
		websiteAdd = l_cmp_website;
		companyDescription = l_cmp_desc;
	}
	
	
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String l_companyID) {
		companyID = l_companyID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String l_companyName) {
		companyName = l_companyName;
	}
	
	public String getWebsiteAdd() {
		return websiteAdd;
	}
	public void setWebsiteAdd(String l_websiteAdd) {
		websiteAdd = l_websiteAdd;
	}
	
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String l_companyDescription) {
		companyDescription = l_companyDescription;
	}


}
