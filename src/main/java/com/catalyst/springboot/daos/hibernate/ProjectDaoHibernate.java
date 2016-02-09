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
	 * Sets EntityManager
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Creates a new row in the Project table in the database and updates references to Technical Lead.
	 * @param project
	 */
	@Override
	public void add(Project project) {
		try {
			Integer userId = project.getTechId().getUserId();
			EndUser endUser = em.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)
					.setParameter("id", userId)
					.getSingleResult();
			project.setTechId(endUser);	
			em.persist(project);	
		} finally {
			em.close();
		}
		
	}

	/**
	 * Method returns list of all available projects.
	 * @return List<Project>
	 */
	@Override
	public List<Project> getAllProjects() {
		try{
			return em.createQuery("SELECT p FROM Project p", Project.class)
					.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Project> getProjectsByUserId(Integer userId){
		try{// WHERE p.projectId IN(SELECT p.projects_projectid FROM p.endUsers WHERE enduser_userid = :id)
			return em.createQuery("SELECT p FROM Project p", Project.class)
				.getResultList();
		} finally {
			em.close();
		}
	}
	
	/**
	 * Method obtains specific project by searching database with @param projectId.
	 * @param projectId
	 * @return project
	 */
	@Override
	public Project getByProjectId(Integer projectId) {
		try{
			return em.createQuery("SELECT p FROM Project p WHERE p.projectId = :id", Project.class)
					.setParameter("id", projectId)
					.getSingleResult();	
		} finally {
			em.close();
		}	 
	}

	/**
	 * Method obtains specific project by searching database with @param projectName.
	 * @param projectName
	 * @return project
	 */
	@Override
	public Project getProjectByProjectName(String projectName){
		return em.createQuery("SELECT p FROM Project p WHERE p.name = :projectname", Project.class)
				 .setParameter("projectname", projectName)
				 .getSingleResult();
	}
	
	/**
	 * Method updates entire project in database with @param project.
	 * @param project.
	 */
	@Override
	public void update(Project project) { 
		em.merge(project);
	}

}
