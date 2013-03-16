/**
 * 
 */
package com.cgweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgweb.dao.UserRepository;
import com.cgweb.dao.UserRepositoryImpl;
import com.cgweb.domain.CompanyInfo;
import com.cgweb.domain.UserInfo;

/**
 * @author SATYAM
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
    
/*    @Autowired
    public void setUserRepository(UserRepositoryImpl userRepository) {
      this.userRepository = userRepository;
    }*/

	@Override
	public UserInfo getUserInfo(String userId) {
		
    	UserInfo userInfo = userRepository.getUserInfo(userId);
    	if(userInfo != null)
    	{
    		System.out.println("LoginEndpoint.processOrder():"+userInfo.getFirstName());
    	}
		return userInfo;
	}

	@Override
	public String changePassword(String userId, String newPassword) {
		String name = userRepository.changePassword(userId, newPassword);
		return name;
	}

	@Override
	public List <UserInfo> getAllUsersInfo() {
		return userRepository.getAllUsersInfo();
	}

	@Override
	public String insertUserInfo(UserInfo userInfo) {
		return userRepository.insertUserInfo(userInfo);
	}

	@Override
	public String insertCompanyInfo(CompanyInfo companyInfo) {
		return userRepository.insertCompanyInfo(companyInfo);
	}
	
	

}
