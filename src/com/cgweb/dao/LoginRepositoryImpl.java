/**
 * 
 */
package com.cgweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cgweb.domain.UserInfo;
import com.cgweb.domain.UserLogin;

/**
 * @author SATYAM
 *
 */
@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserInfo authenticateUser(String username, String password) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery <UserInfo> criteriaQuery = criteriaBuilder.createQuery(UserInfo.class);
		Root from;
		from = criteriaQuery.from(UserInfo.class);

		criteriaQuery.where(criteriaBuilder.equal(from.get("id"), username));
		//,criteriaBuilder.equal(from.get("password"), password));

		CriteriaQuery <UserInfo> select = criteriaQuery.select(from);
		System.out.println("111111111");
		TypedQuery <UserInfo> typedQuery = entityManager.createQuery(select);
		System.out.println("22222222222");
		List <UserInfo> resultList = typedQuery.getResultList();
		System.out.println("33333333333");
		
		// no need of null check, auto check
		if (resultList != null && resultList.size() >= 1)
		{
			System.out.println("444444444");
			return resultList.iterator().next();
		}
		System.out.println("555555555");
		return null;
		
		/*UserInfo userInfo = new UserInfo();
		
		UserLogin userlogin = entityManager.find(UserLogin.class, username);
		System.out.println("LoginRepositoryImpl.authenticateUser():"+userlogin);
		if(userlogin != null)
		{
			return userlogin.getUserName();
		}
		else
		{
			return "No User Found";
		}*/
	}
}
