package com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.InvalidInputException;
import com.catalyst.springboot.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public void setprojectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public List<Project> getProjects() {

		List<Project> projects = projectDao.getAllProjects();
		return projects;
	}

	@Override
	public void add(Project project) {
		projectDao.add(project);
	}

	@Override
	public void update(Project project) {
		projectDao.update(project);
	}

	@Override
	public Project getByProjectId(Integer projectId) throws InvalidInputException {
		if (projectId == null || projectId < 0) {
			throw new InvalidInputException("projectId.NullOrNegative");
		}
		return projectDao.getByProjectId(projectId);
	}

	@Override
	public Project getProjectByProjectName(String projectName) throws InvalidInputException {
		if (projectName == null || projectName == "") {
			throw new InvalidInputException("projectName null or empty");
		}
		return projectDao.getProjectByProjectName(projectName);

	}
}
