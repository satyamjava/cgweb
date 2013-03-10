/**
 * 
 */
package com.cgweb.service;

import com.cgweb.domain.UserLogin;

/**
 * @author SATYAM
 *
 */
public interface LoginService {
	
	UserLogin getUserLogin(String userName, String password);

}
