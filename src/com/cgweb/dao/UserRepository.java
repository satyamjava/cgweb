/**
 * 
 */
package com.cgweb.dao;

import java.util.List;

import com.cgweb.domain.CompanyInfo;
import com.cgweb.domain.UserInfo;

/**
 * @author SATYAM
 *
 */
public interface UserRepository {
	
	public UserInfo getUserInfo(String userId);
	public List <UserInfo> getAllUsersInfo();
	public String changePassword(String userId, String newPassword);
	public String insertUserInfo(UserInfo userInfo);
	public String insertCompanyInfo(CompanyInfo companyInfo);
}
