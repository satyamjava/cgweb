/**
 * 
 */
package com.cgweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgweb.dao.LoginRepository;
import com.cgweb.dao.LoginRepositoryImpl;
import com.cgweb.domain.UserInfo;

/**
 * @author SATYAM
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
    
    @Autowired
    public void setLoginRepository(LoginRepositoryImpl loginRepository) {
      this.loginRepository = loginRepository;
    }

	@Override
	public UserInfo getUserInfo(String userName, String password) {
		
    	UserInfo userInfo = loginRepository.authenticateUser(userName, password);
    	if(userInfo != null)
    	{
    		System.out.println("LoginEndpoint.processOrder():"+userInfo.getFirstName());
    	}
    	
		return null;
	}

}
