package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.Project;

@Transactional
@Component 
public class ProjectDaoHibernate implements ProjectDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(Project project) {
		Integer userId = project.getTechId().getUserId();
		EndUser endUser = em.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)
		.setParameter("id", userId)
		.getSingleResult();
		project.setTechId(endUser);
		
		em.persist(project);
		
	}

	@Override
	public List<Project> getAllProjects() {
		
		return em.createQuery("SELECT p FROM project p", Project.class).
				getResultList();
	}

	@Override
	public Project getByProjectId(Integer projectId) {	
		return em.createQuery("SELECT p FROM project p WHERE p.projectId = :id", Project.class)
				.setParameter("id", projectId)
				.getSingleResult();	 
	}

	@Override
	public Project getProjectByProjectName(String projectname){
		return em.createQuery("SELECT p FROM project p WHERE p.projectname = :projectname", Project.class)
				 .setParameter("projectname", projectname)
				 .getSingleResult();
	}
	@Override
	public void update(Project project) { 
		em.merge(project);
	}

}
