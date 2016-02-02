package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.Project;

/**
 * The following Hibernate commands complete the CRUD functionality of the ProjectDao
 * by connecting Java to the database. 
 * @author ldahlberg
 * @author gwalpole
 */
@Transactional
@Component 
public class ProjectDaoHibernate implements ProjectDao {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Sets EntityManager for ProjectDaoHibernate
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Adds Project information to storage.
	 * @param project contains userId; userId is used to get EndUser then set EndUser for JoinColumn connection.
	 */
	@Override
	public void add(Project project) {
		Integer userId = project.getTechId().getUserId();
		EndUser endUser = em.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)
				.setParameter("id", userId)
				.getSingleResult();
		project.setTechId(endUser);
		
		em.persist(project);
		
	}

	/**
	 * Method returns list of all available projects.
	 */
	@Override
	public List<Project> getAllProjects() {
		
		return em.createQuery("SELECT p FROM project p", Project.class).
				getResultList();
	}
	
	/**
	 * Method obtains specific project by searching database with @param projectId.
	 */
	@Override
	public Project getByProjectId(Integer projectId) {	
		return em.createQuery("SELECT p FROM project p WHERE p.projectId = :id", Project.class)
				.setParameter("id", projectId)
				.getSingleResult();	 
	}

	/**
	 * Method obtains specific project by searching database with @param projectName.
	 */
	@Override
	public Project getProjectByProjectName(String projectName){
		return em.createQuery("SELECT p FROM project p WHERE p.name = :projectname", Project.class)
				 .setParameter("projectname", projectName)
				 .getSingleResult();
	}
	
	/**
	 * Method updates entire project in database with @param project.
	 */
	@Override
	public void update(Project project) { 
		em.merge(project);
	}

}
