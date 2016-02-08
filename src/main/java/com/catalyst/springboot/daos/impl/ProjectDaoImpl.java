package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.Project;

/**
 * The following Hibernate commands complete the CRUD functionality of the ProjectDao
 * by connecting Java to the database.
 * @author ldahlberg
 * @author gwalpole
 */
public class ProjectDaoImpl implements ProjectDao{
	
	private List<Project> projects = new ArrayList<>();
	private Integer nextId = 1;
	
	/**
	 * Method calls ProjectDao function add and sends @param to ProjectDaoHibernate
	 */
	@Override
	public void add(Project project) {
		project.setProjectId(nextId);
		nextId++;
		projects.add(project);	
	}
	
	/**
	 * Method calls ProjectDao function update and sends @param to ProjectDaoHibernate
	 */
	@Override
	public void update(Project project) {
		Integer index = projects.indexOf(project);
		projects.set(index, project);
	}
	
	/**
	 * Method calls ProjectDao function getAllProjects and returns
	 * all Projects from ProjectDaoHibernate.
	 */
	@Override
	public List<Project> getAllProjects() { 
		return projects;
	}
	
	/**
	 * Method calls ProjectDao function getByProjectId with @param projectId, checks for match,
	 * and returns single project from ProjectDaoHibernate.
	 */
	@Override
	public Project getByProjectId(Integer projectId) {
		for(Project p : projects){
			if(p.getProjectId().equals(projectId)){
				return p;
			}
		}
		return null;
	}

	/**
	 * Method calls ProjectDao function getByProjectId with @param projectName, checks for match,
	 * and returns single project from ProjectDaoHibernate.
	 */
	@Override
	public Project getProjectByProjectName(String projectName) {
		for(Project p : projects){
			if(p.getName().equals(projectName)){
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Project> getProjectsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
