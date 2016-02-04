package com.catalyst.springboot.daos;

import java.util.List;

import com.catalyst.springboot.entities.Project;

/**
 * The methods declared in this interface are to provide basic CRUD functionality related to Project objects.
 * @author ldahlberg
 * @author gwalpole
 */
public interface ProjectDao {
	/**
	 * Adds information about an Project to storage.
	 * @param project
	 */
	void add(Project project);

	/**
	 * Updates the information about an Project already in storage.
	 * @param project
	 */
	void update(Project project);

	/**
	 * Retrieves all Projects currently in storage.
	 * @return
	 */
	List<Project> getAllProjects();

	/**
	 * Retrieve information about a single Project from storage with a matching ProjectId
	 * @param projectId
	 * @return
	 */
	Project getByProjectId(Integer projectId);

	/**
	 * Retrieves an Project with a matching ProjectName.
	 * 
	 * @param projectName
	 * @return 
	 */
	Project getProjectByProjectName(String projectName);

}
