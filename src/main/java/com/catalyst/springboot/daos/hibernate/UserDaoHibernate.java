package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.UserDao;
import com.catalyst.springboot.entities.User;


@Transactional
@Component 
public class UserDaoHibernate implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(User user) {
		em.persist(user);
		
	}


	@Override
	public List<User> getAllUsers() {
		
		return em.
				createQuery("SELECT e FROM user e", User.class).
				getResultList();
	}

	@Override
	public User getByUserId(Integer userId) {	
		return em
				.createQuery("SELECT e FROM user e WHERE e.userId = :id", User.class)
				.setParameter("id", userId)
				.getSingleResult();	 
	}

	@Override
	public User getUserByUsername(String username){
		return em.createQuery("SELECT e FROM user e WHERE e.username = :username", User.class)
				 .setParameter("username", username)
				 .getSingleResult();
	}
	@Override
	public void update(User user) { 
		em.merge(user);
	}

	@Override
	public void delete(Integer userId) {
		User user = getByUserId(userId);
		em.remove(user);
		
	}

}
