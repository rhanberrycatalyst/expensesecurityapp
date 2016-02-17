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
import org.mockito.stubbing.Answer;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.SpringRole;

public class EndUserDaoHibernateTest {

	private EndUserDaoHibernate target;
	private EndUser mockEndUser;
    private SpringRole mockSpringRole;
	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new EndUserDaoHibernate();
		mockSpringRole=new SpringRole();
		mockEm = mock(EntityManager.class);
		mockEndUser=new EndUser();
		target.setEm(mockEm);
	}

	@Test
	public void testAdd() {
		target.add(mockEndUser);
		
		//We have nothing we can assert. So use verify to check how many times a dependency's method was called.
		//verify(mockEm, times(1)).persist();
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
	public void testUpdate() {
		EndUser expected = new EndUser();
		expected.setUserId(1);
	
		target.update(expected);
		
		verify(mockEm, times(1)).merge(expected);
	}

}
