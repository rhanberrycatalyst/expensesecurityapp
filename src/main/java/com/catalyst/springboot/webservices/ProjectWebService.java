package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.services.ProjectService;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.InvalidInputException;

/**
 * The methods below request mappings for connection 
 * between web services and Java through Spring annotations
 * @author ldahlberg
 * @author gwalpole
 */
@RestController
public class ProjectWebService {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * This method sets the WebService for ProjectService.
	 */
	public void setprojectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	/**
	 * This method maps the value of projects for POST requests.
	 * @param project
	 */
	@RequestMapping(value="/projects", method=RequestMethod.POST)
	public void addProject(@RequestBody Project project){
		projectService.add(project);
	} 
	
	/**
	 * This method maps the value of projects for GET requests of all projects.
	 * @return List<Project>
	 */
	@RequestMapping(value="/projects", method = RequestMethod.GET)
	public List<Project> getProjects(){
		return projectService.getProjects();
	}	
	
	@RequestMapping(value="/projectsusers/{userId}", method = RequestMethod.GET)
	public List<Project> getProjectsByUserId(@PathVariable Integer userId){
		System.out.println(userId);
		return projectService.getProjectsByUserId(userId);
	}
	
	/**
	 * This method maps the value of projects for GET requests of single project with 
	 * @param id
	 * @return Project
	 */
	@RequestMapping(value="/projects/{id}", method=RequestMethod.GET)
	public Project getProjectByID(@PathVariable Integer id) throws InvalidInputException{ 
		return projectService.getByProjectId(id);
	}
	
	/**
	 * This method maps the value of projects for PUT requests of single project with 
	 * @param id and @param project
	 */
	@RequestMapping(value="/projects/{id}", method = RequestMethod.PUT)
	public void updateuser(@PathVariable Integer id, @RequestBody Project project){
		projectService.update(project);
	}
	
	/**
	 * This method maps the value of projects for GET requests of single project with 
	 * @param name
	 * @return Project
	 */
	@RequestMapping(value="/projectname/{name}", method=RequestMethod.GET)
	public Project getProjectByName(@PathVariable String name) throws InvalidInputException{ 
		return projectService.getProjectByProjectName(name);
	}
}
