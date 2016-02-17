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
import com.catalyst.springboot.entities.SpringRole;

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
		target.setEm(mockEm);
	}

	@Test
	public void testAdd() {
		TypedQuery<SpringRole> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT s FROM SpringRole s WHERE s.roleId = 2", SpringRole.class)).thenReturn(mockTypedQuery);
		target.add(mockEndUser);
		
		//We have nothing we can assert. So use verify to check how many times a dependency's method was called.
		verify(mockEm, times(1)).persist(mockEndUser);
	}

	@Test
	public void testGetAllusers() {

		List<EndUser> expected = new ArrayList<>();

		TypedQuery<EndUser> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(EndUser.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllEndUsers();

		verify(mockTypedQuery, times(1)).getResultList();

	}

	@Test
	public void testGetByuserId() {
		TypedQuery<EndUser> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(EndUser.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		
		
		target.getByEndUserId(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
		
	}

	@Test
	public void testGetEndUserByEndUsername() {
		TypedQuery<EndUser> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(EndUser.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		
		
		target.getEndUserByEndUsername("user@user.com");
		verify(mockTypedQuery, times(1)).setParameter(eq("email"), eq("user@user.com"));
		
	}
	@Test
	public void testUpdate() {
		EndUser expected = new EndUser();
		expected.setUserId(1);
	
		target.update(expected);
		
		verify(mockEm, times(1)).merge(expected);
	}

}
