package com.catalyst.springboot.daos.hibernate;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.Project;

public class ProjectDaoHibernateTest {

	private ProjectDaoHibernate target;
	private EndUser mockEndUser;
	private Project mockProject;
	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new ProjectDaoHibernate();
		mockEm = mock(EntityManager.class);
		mockEndUser=mock(EndUser.class);
		mockProject = mock(Project.class);
		target.setEm(mockEm);
	}

	@Test
	public void testProjectAdd() {
		EndUser mockEndUser2 = mock(EndUser.class);
		when(mockProject.getTechId()).thenReturn(mockEndUser2);
		when(mockEndUser2.getUserId()).thenReturn(1);
		
		TypedQuery<EndUser> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter("id", 1)).thenReturn(mockTypedQuery);
		target.add(mockProject);
		
		//We have nothing we can assert. So use verify to check how many times a dependency's method was called.
		verify(mockEm, times(1)).persist(mockProject);
	}

	@Test
	public void testGetAllProjects() {

		List<Project> expected = new ArrayList<>();

		TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllProjects();

		verify(mockTypedQuery, times(1)).getResultList();

	}

	@Test
	public void testGetByProjectId() {
		TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		
		target.getByProjectId(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
		
	}

	@Test
	public void testGetProjectByProjectName() {
		TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedQuery);
		 		 
		target.getProjectByProjectName("test");
		verify(mockTypedQuery, times(1)).setParameter(eq("projectname"), eq("test"));
		
	}
	@Test
	public void testUpdate() {
		Project expected = new Project();
		expected.setProjectId(1);
	
		target.update(expected);
		
		verify(mockEm, times(1)).merge(expected);
	}

}
