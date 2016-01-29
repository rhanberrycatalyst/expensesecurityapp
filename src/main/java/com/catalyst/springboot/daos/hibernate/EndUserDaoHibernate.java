package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;


@Transactional
@Component 
public class EndUserDaoHibernate implements EndUserDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(EndUser endUser) {
		em.persist(endUser);
		
	}


	@Override
	public List<EndUser> getAllEndUsers() {
		
		return em.
				createQuery("SELECT e FROM endUser e", EndUser.class).
				getResultList();
	}

	@Override
	public EndUser getByEndUserId(Integer endUserId) {	
		return em
				.createQuery("SELECT e FROM endUser e WHERE e.userId = :id", EndUser.class)
				.setParameter("id", endUserId)
				.getSingleResult();	 
	}

	@Override
	public EndUser getEndUserByEndUsername(String endUsername){
		return em.createQuery("SELECT e FROM endUser e WHERE e.endUsername = :endUsername", EndUser.class)
				 .setParameter("endUsername", endUsername)
				 .getSingleResult();
	}
	@Override
	public void update(EndUser endUser) { 
		em.merge(endUser);
	}

	@Override
	public void delete(Integer endUserId) {
		EndUser endUser = getByEndUserId(endUserId);
		em.remove(endUser);
		
	}

}
