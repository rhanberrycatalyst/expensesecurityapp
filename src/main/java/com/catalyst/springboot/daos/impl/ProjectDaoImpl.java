package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.Project;

public class ProjectDaoImpl implements ProjectDao{

	private List<Project> projects = new ArrayList<>();
	private Integer nextId = 1;

	@Override
	public void add(Project project) {
		project.setProjectId(nextId);
		nextId++;
		projects.add(project);

	}

	@Override
	public void update(Project project) {
		Integer index = projects.indexOf(project);
		projects.set(index, project);
	}


	@Override
	public List<Project> getAllProjects() {
		return projects;
	}

	@Override
	public Project getByProjectId(Integer projectId) {
		for(Project p : projects){
			if(p.getProjectId().equals(projectId)){
				return p;
			}
		}
		return null;
	}

	@Override
	public Project getProjectByProjectName(String projectname) {
		for(Project p : projects){
			if(p.getName().equals(projectname)){
				return p;
			}
		}
		return null;
	}
}
