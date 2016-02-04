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

		
		return em.createQuery("SELECT e FROM EndUser e", EndUser.class).
				getResultList();
	}

	@Override
	public EndUser getByEndUserId(Integer endUserId) {	
		return em.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)
				.setParameter("id", endUserId)
				.getSingleResult();
	}

	@Override
	public EndUser getEndUserByEndUsername(String email){

		return em.createQuery("SELECT e FROM EndUser e WHERE e.email = :email", EndUser.class)
				 .setParameter("email", email)
				 .getSingleResult();
	}
	@Override
	public void update(EndUser endUser) {
		em.merge(endUser);
	}
}
