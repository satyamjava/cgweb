/**
 * 
 */
package com.cgweb.service;

import java.util.List;

import com.cgweb.domain.UserInfo;

/**
 * @author SATYAM
 *
 */
public interface UserService {
	
	public UserInfo getUserInfo(String userId);
	public List <UserInfo> getAllUsersInfo();
	public String changePassword(String userId, String newPassword);
	public String insertUserInfo(UserInfo userInfo);

}
