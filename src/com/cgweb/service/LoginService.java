/**
 * 
 */
package com.cgweb.service;

import com.cgweb.domain.UserInfo;

/**
 * @author SATYAM
 *
 */
public interface LoginService {
	
	UserInfo getUserInfo(String userName, String password);

}
