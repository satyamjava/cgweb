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

import com.cgweb.domain.UserLogin;

/**
 * @author SATYAM
 *
 */
@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserLogin authenticateUser(String username, String password) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery <UserLogin> criteriaQuery = criteriaBuilder.createQuery(UserLogin.class);
		Root from;
		from = criteriaQuery.from(UserLogin.class);

		criteriaQuery.where(criteriaBuilder.equal(from.get("id"), username));
		//,criteriaBuilder.equal(from.get("password"), password));

		CriteriaQuery <UserLogin> select = criteriaQuery.select(from);
		TypedQuery <UserLogin> typedQuery = entityManager.createQuery(select);
		List <UserLogin> resultList = typedQuery.getResultList();
		
		// no need of null check, auto check
		if (resultList != null && resultList.size() >= 1)
		{
			return resultList.iterator().next();
		}
		return null;
		
		/*UserLogin UserLogin = new UserLogin();
		
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
