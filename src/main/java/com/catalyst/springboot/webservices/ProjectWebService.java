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

@RestController
public class ProjectWebService {
	
	@Autowired
	private ProjectService projectService;
	
	public void setprojectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping(value="/projects", method=RequestMethod.POST)
	public void adduser(@RequestBody Project project){
		projectService.add(project);
	} 
		
		
	@RequestMapping(value="/projects", method = RequestMethod.GET)
	public List<Project> getProjects(){
		return projectService.getProjects();
	}	
	
	@RequestMapping(value="/projects/{id}", method=RequestMethod.GET)
	public Project getProjectByID(@PathVariable Integer id) throws InvalidInputException{ 
		return projectService.getByProjectId(id);
	}
	
	@RequestMapping(value="/projects/{id}", method = RequestMethod.PUT)
	public void updateuser(@PathVariable Integer id, @RequestBody Project project){
		projectService.update(project);
	}
}
