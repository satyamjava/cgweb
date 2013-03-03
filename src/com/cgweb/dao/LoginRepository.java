/**
 * 
 */
package com.cgweb.dao;

import com.cgweb.domain.UserInfo;

/**
 * @author SATYAM
 *
 */
public interface LoginRepository {
	
	public UserInfo authenticateUser(String username, String password);

}
