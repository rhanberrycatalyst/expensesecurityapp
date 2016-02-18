package com.catalyst.springboot.services.impl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.InvalidInputException;

public class ProjectServiceImplTest {

	private ProjectServiceImpl target;
	private ProjectDao mockProjectDao;
	private Project mockProject;
	
	
	@Before
	public void setup(){
		target = new ProjectServiceImpl();
		mockProjectDao = mock(ProjectDao.class);
		target.setProjectDao(mockProjectDao);
		mockProject = mock(Project.class);
	}

	@Test
	public void testAddProject(){
		
		target.add(mockProject);
		verify(mockProjectDao, times(1)).add(mockProject);
	}

	@Test
	public void testProjects() {
		List<Project> expected = new ArrayList<>();
		when(mockProjectDao.getAllProjects()).thenReturn(expected);
		target.getProjects();
		verify(mockProjectDao, times(1)).getAllProjects();
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByProjectIdZero() throws InvalidInputException{
		target.getByProjectId(-1);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByProjectNull() throws InvalidInputException{
		target.getByProjectId(null);
	}
	
	@Test
	public void testGetByProjectIdSuccess() throws InvalidInputException{
		target.getByProjectId(1);
		verify(mockProjectDao, times(1)).getByProjectId(any());
	}
	
	@Test
	public void testUpdateProject(){
		
		target.update(mockProject);
		verify(mockProjectDao, times(1)).update(mockProject);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByProjectNameEmpty() throws InvalidInputException{
		target.getProjectByProjectName("");
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByProjectNameNull() throws InvalidInputException{
		target.getProjectByProjectName(null);
	}
	
	@Test
	public void testGetByProjectNameSuccess() throws InvalidInputException{
		target.getProjectByProjectName("test");
		verify(mockProjectDao, times(1)).getProjectByProjectName("test");
	}

	/*
	@Test
	public void testUpdateUserMatch(){
		EndUser paramUser = mock(EndUser.class);
		when(paramUser.getUserId()).thenReturn(1);
		when(mockuserDao.getByEndUserId(1)).thenReturn(mockEndUser);
		when(mockEndUser.getPassword()).thenReturn("test");
		when(paramUser.getPassword()).thenReturn("test");
		
		doNothing().when(paramUser).setPassword("test");
		target.update(paramUser);
		verify(mockuserDao, times(1)).update(paramUser);
	}
	
	@Test
	public void testUpdateUserEmpty(){
		EndUser paramUser = mock(EndUser.class);
		when(paramUser.getUserId()).thenReturn(1);
		when(mockuserDao.getByEndUserId(1)).thenReturn(mockEndUser);
		when(mockEndUser.getPassword()).thenReturn("test");
		when(paramUser.getPassword()).thenReturn("");
		
		doNothing().when(paramUser).setPassword("test");
		target.update(paramUser);
		verify(mockuserDao, times(1)).update(paramUser);
	}
	
	@Test
	public void testUpdateUserNewPassword(){
		EndUser paramUser = mock(EndUser.class);
		when(paramUser.getUserId()).thenReturn(1);
		when(mockuserDao.getByEndUserId(1)).thenReturn(mockEndUser);
		when(mockEndUser.getPassword()).thenReturn("test");
		when(paramUser.getPassword()).thenReturn("test2");
		
		when(mockEncoder.encode("test2")).thenReturn("test2");
		doNothing().when(paramUser).setPassword("test");
		target.update(paramUser);
		verify(mockuserDao, times(1)).update(paramUser);
	}
	
	
	
	
	
	@Test
	public void testGetUserByUserName(){
		target.getUserByUsername("Luke");
		
		verify(mockuserDao, times(1)).getEndUserByEndUsername(any());
	}*/
	
}
