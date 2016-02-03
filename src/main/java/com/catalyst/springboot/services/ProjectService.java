package com.catalyst.springboot.services;

import java.util.List;

import com.catalyst.springboot.entities.Project;

/**
 * The methods declared in this interface are to provide basic CRUD functionality 
 * related to Project Services.
 * @author ldahlberg
 * @author gwalpole
 */
public interface ProjectService {
	/**
	 * Add a new project to the application.
	 *
	 * @param project
	 */
	void add(Project project);

	/**
	 * Update the information in an existing project. The projectId is used to
	 * find the unique project's information.
	 *
	 * @param project
	 */
	void update(Project project);

	/**
	 * Retrieve all projects from the application.
	 *
	 * @param isActive
	 *            - optional parameter. If supplied, will only retrieve
	 *            projects with matching values. If null, all projects are
	 *            returned.
	 * @return
	 */
	List<Project> getProjects();

	/**
	 * Retrieve a single project's information if that project's projectId
	 * matches the supplied projectId
	 *
	 * @param projectId
	 * @return
	 * @throws InvalidInputException
	 *             - the value of projectId provided should not be null or less
	 *             than 0
	 */
	Project getByProjectId(Integer projectId) throws InvalidInputException;

	/**
	 * Retrieve a single project's information if that project's projectname
	 * matches the supplied projectname.
	 *
	 * @param projectname
	 * @return
	 * @throws InvalidInputException
	 */
	Project getProjectByProjectName(String projectname) throws InvalidInputException;

}
