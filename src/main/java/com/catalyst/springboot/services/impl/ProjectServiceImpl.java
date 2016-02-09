package com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.InvalidInputException;
import com.catalyst.springboot.services.ProjectService;

/**
 * The methods below implements the ProjectService interface
 * @author ldahlberg
 * @author gwalpole
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;

	/**
	 * Method sets the ProjectDao of Service with
	 * @param projectDao
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * Method returns
	 * @return List<Project>
	 */
	@Override
	public List<Project> getProjects() {
		List<Project> projects = projectDao.getAllProjects();
		return projects;
	}

	/**
	 * Method adds 
	 * @param project.
	 */
	@Override
	public void add(Project project) {
		projectDao.add(project);
	}

	/**
	 * Method updates single project
	 * @param project.
	 */
	@Override
	public void update(Project project) {
		projectDao.update(project);
	}

	/**
	 * Method gets single project with
	 * @param projectId. 
	 * If projectId is null or negative value, method 
	 * @throws InvalidInputException.
	 * @return Project
	 */
	@Override
	public Project getByProjectId(Integer projectId) throws InvalidInputException {
		if (projectId == null || projectId < 0) {
			throw new InvalidInputException("projectId.NullOrNegative");
		}
		return projectDao.getByProjectId(projectId);
	}

	/**
	 * Method gets single project with
	 * @param projectName. 
	 * If projectId is null or empty, method 
	 * @throws InvalidInputException.
	 * @return Project
	 */
	@Override
	public Project getProjectByProjectName(String projectName) throws InvalidInputException {
		if (projectName == null || projectName == "") {
			throw new InvalidInputException("projectName null or empty");
		}
		return projectDao.getProjectByProjectName(projectName);
	}

	@Override
	public List<Project> getProjectsByUserId(Integer userId) {
		return projectDao.getProjectsByUserId(userId);
	}
}
