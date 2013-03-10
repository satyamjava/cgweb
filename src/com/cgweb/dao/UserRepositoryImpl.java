/**
 * 
 */
package com.cgweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cgweb.domain.UserInfo;
import com.cgweb.domain.UserLogin;

/**
 * @author SATYAM
 *
 */

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserInfo getUserInfo(String userId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery <UserInfo> criteriaQuery = criteriaBuilder.createQuery(UserInfo.class);
		Root from;
		from = criteriaQuery.from(UserInfo.class);

		criteriaQuery.where(criteriaBuilder.equal(from.get("id"), Integer.parseInt(userId)));
		//,criteriaBuilder.equal(from.get("password"), password));

		CriteriaQuery <UserInfo> select = criteriaQuery.select(from);
		TypedQuery <UserInfo> typedQuery = entityManager.createQuery(select);
		List <UserInfo> resultList = typedQuery.getResultList();
		System.out.println("UserRepositoryImpl.getUserInfo() resultList: "+resultList);
		// no need of null check, auto check
		if (resultList.size() >= 1)
		{
			System.out.println("UserRepositoryImpl.getUserInfo() resultList.size: "+resultList.size());
			return resultList.iterator().next();
		}
		System.out.println("UserRepositoryImpl.getUserInfo(): About to return null");
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

	public List <UserInfo> getAllUsersInfo() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery <UserInfo> criteriaQuery = criteriaBuilder.createQuery(UserInfo.class);
		Root from;
		from = criteriaQuery.from(UserInfo.class);

		//criteriaQuery.where(criteriaBuilder.equal(from.get("id"), Integer.parseInt(userId)));
		//,criteriaBuilder.equal(from.get("password"), password));

		CriteriaQuery <UserInfo> select = criteriaQuery.select(from);
		TypedQuery <UserInfo> typedQuery = entityManager.createQuery(select);
		List <UserInfo> resultList = typedQuery.getResultList();
		System.out.println("UserRepositoryImpl.getAllUsersInfo() resultList: "+resultList);
		// no need of null check, auto check
		if (resultList.size() >= 1)
		{
			System.out.println("UserRepositoryImpl.getAllUsersInfo() resultList.size: "+resultList.size());
			return resultList;
		}
		System.out.println("UserRepositoryImpl.getAllUsersInfo(): About to return null");
		return null;
	
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String changePassword(String userId, String newPassword) {
		/*
		Query query = entityManager.createQuery("UPDATE UserLogin SET password='XYZ' WHERE id=1");
		int result = query.executeUpdate();
		
		//System.out.println("UserRepositoryImpl.changePassword():user.getPassword():"+user.getPassword());
		System.out.println("UserRepositoryImpl.changePassword():result:"+result);*/
		
		UserLogin user = entityManager.find(UserLogin.class, Integer.parseInt(userId));
		user.setPassword(newPassword);
		entityManager.merge(user);
		try {
			entityManager.flush();
		  } catch (PersistenceException exception) {
		   exception.printStackTrace();
		  }
		user = entityManager.find(UserLogin.class, Integer.parseInt(userId));
		if(user.getPassword().equalsIgnoreCase(newPassword))
		{
			System.out.println("UserRepositoryImpl.changePassword() SUCCESS");
			return "SUCCESS";
		}
		return "FAILURE";
		
		
		/*//System.out.println("UserRepositoryImpl.changePassword():"+userId+":pass:"+newPassword);
		UserLogin user = entityManager.getReference(UserLogin.class, userId);
		//System.out.println("UserRepositoryImpl.changePassword():Password in database:"+user.getPassword());
		//user.setPassword(newPassword);
		//System.out.println("UserRepositoryImpl.changePassword():Password after setting:"+user.getPassword());
		//entityManager.getTransaction().begin();
		//UserLogin user = new UserLogin();
		user.setPassword(newPassword);
		UserLogin updatedUser = entityManager.merge(user);
		//user.setPassword(newPassword);
		//entityManager.getTransaction().commit();
		System.out.println("UserRepositoryImpl.changePassword():user.getPassword():"+updatedUser.getPassword());
		System.out.println("UserRepositoryImpl.changePassword():");
		//user = entityManager.find(UserLogin.class, userId);
		//entityManager.close();
		if(user.getPassword().equalsIgnoreCase(newPassword))
		{
			System.out.println("UserRepositoryImpl.changePassword() SUCCESS");
			return "SUCCESS";
		}
		return "FAILURE";*/
	}
	
	/**
	 * Contact newInstance = entityManager.merge(contact);
newInstance.setFirstName("Peter4");
	 * 
	 * 
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Car> getCars() throws DataAccessException {
		Query query = getEntityManager().createQuery("select c from Car c");
		List<Car> resultList = query.getResultList();
		return resultList;
	}
	@Transactional
	public Car getCar(Long carId) throws DataAccessException {
		return getEntityManager().find(Car.class, carId);
	}
	 */
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String insertUserInfo(UserInfo userInfo) {
		System.out.println("UserRepositoryImpl.insertUserInfo(): Entering:"+userInfo);
		//entityManager.getTransaction().begin();
		entityManager.persist(userInfo);
		//entityManager.getTransaction().commit();
		//System.out.println("UserRepositoryImpl.getUserInfo() resultList: "+resultList);
		System.out.println("UserRepositoryImpl.insertUserInfo(): About to return null");
		try {
			entityManager.flush();
		  } catch (PersistenceException exception) {
		   exception.printStackTrace();
		  }
		  return String.valueOf(userInfo.getId());
	}
}
