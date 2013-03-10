/**
 * 
 */
package com.cgweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgweb.dao.LoginRepository;
import com.cgweb.dao.LoginRepositoryImpl;
import com.cgweb.domain.UserLogin;

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
	public UserLogin getUserLogin(String userName, String password) {
		
    	UserLogin UserLogin = loginRepository.authenticateUser(userName, password);
    	if(UserLogin != null)
    	{
    		System.out.println("LoginEndpoint.processOrder():"+UserLogin.getUserName());
    	}
    	
		return null;
	}

}
