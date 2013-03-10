/**
 * 
 */
package com.cgweb.dao;

import com.cgweb.domain.UserLogin;

/**
 * @author SATYAM
 *
 */
public interface LoginRepository {
	
	public UserLogin authenticateUser(String username, String password);

}
