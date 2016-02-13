package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.SpringRole;

/**
 * The hibernate functionality for the End User table's Database access
 * @author ldahlberg
 * @author gwalpole
 */
@Transactional
@Component
public class EndUserDaoHibernate implements EndUserDao{

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Sets the EntityManager
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Creates a new row in the EndUser table in the database.
	 * @param endUser 
	 */
	@Override
	public void add(EndUser endUser) {
			SpringRole springRole = em.createQuery("SELECT s FROM SpringRole s WHERE s.roleId = 2", SpringRole.class)
				.getSingleResult();
			endUser.setSpringrole(springRole);
			em.persist(endUser);		
	}

	/**
	 * Returns a list of all the rows in the EndUser table.
	 * @return List<EndUser>
	 */
	@Override
	public List<EndUser> getAllEndUsers() {
			return em.createQuery("SELECT e FROM EndUser e", EndUser.class).
					getResultList();
		
	}

	/**
	 * Returns a single row from the EndUser table with the passed in user id.
	 * @param endUserId
	 * @return EndUser
	 */
	@Override
	public EndUser getByEndUserId(Integer endUserId) {
			return em.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)
					.setParameter("id", endUserId)
					.getSingleResult();
	}

	/**
	 * Returns a single row from the EndUser table with the passed in user name.
	 * @param lastname
	 * @return EndUser
	 */
	@Override

	public EndUser getEndUserByEndUsername(String email){
			return em.createQuery("SELECT e FROM EndUser e WHERE e.email = :email", EndUser.class)
					 .setParameter("email", email)
					 .getSingleResult();
		
	}

	/**
	 * Updates a single row from the EndUser table corresponding to the 
	 * passed-in EndUser object.
	 * @param endUser
	 */
	@Override
	public void update(EndUser endUser) {
		em.merge(endUser);
	}
}
