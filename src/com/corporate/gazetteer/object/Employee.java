package com.corporate.gazetteer.object;

public class Employee extends EmpCompClientStak {
		
	public String userId;
	public String email;
	public String firstName;
	public String middleName;
	public String lastName;
	public boolean gender;	//true is Male, false is Female			
	public String cmpanyName;	
	public String designation;
	public String skill;
	public String doj;
	public int experince;
	
	public Employee(String l_userid, String l_email, String l_f_name, String l_m_name, String l_l_name, boolean l_gender, String l_company_name, String l_designation, String l_skill, String l_doj, int l_expr, String l_roll, String l_mobile, String l_phone, String l_fax, String l_add_1, String l_add_2, String l_city, String l_state, String l_zip, String l_country) {
		
		super(l_roll, l_mobile, l_phone,  l_fax,  l_add_1,  l_add_2,  l_city,  l_state,  l_zip,  l_country);
		
		userId = l_userid;
		email = l_email;
		firstName = l_f_name;
		middleName = l_m_name;
		lastName = l_l_name;
		gender = l_gender;			
		cmpanyName = l_company_name;	
		designation = l_designation;
		skill = l_skill;
		doj = l_doj;
		experince = l_expr;
		
		
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String l_userId) {
		userId = l_userId;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String l_email) {
		email = l_email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String l_firstName) {
		firstName = l_firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String l_middleName) {
		middleName = l_middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String l_lastName) {
		lastName = l_lastName;
	}
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean l_gender) {
		gender = l_gender;
	}
	
	public String getCmpanyName() {
		return cmpanyName;
	}
	public void setCmpanyName(String l_cmpanyName) {
		cmpanyName = l_cmpanyName;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String l_designation) {
		designation = l_designation;
	}
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String l_skill) {
		skill = l_skill;
	}
	
	public String getDoj() {
		return doj;
	}
	public void setDoj(String l_doj) {
		doj = l_doj;
	}
		
	public int getExperince() {
		return experince;
	}
	public void setExperince(int l_experince) {
		experince = l_experince;
	}
	
}
