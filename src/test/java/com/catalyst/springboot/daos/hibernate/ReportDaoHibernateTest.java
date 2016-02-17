package com.catalyst.springboot.daos.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportStatus;
import com.catalyst.springboot.entities.SpringRole;
import com.catalyst.springboot.entities.Type;

public class ReportDaoHibernateTest {
	private ReportDaoHibernate target;
	private Report mockReport;
	private SpringRole mockSpringRole;
	private EndUser mockEndUser;
	private Project mockProject;
	private ReportStatus mockReportStatus;
	private LineItem mockLineItem;
	private Type mockType;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		target = new ReportDaoHibernate();
		mockSpringRole=new SpringRole();
		mockEndUser =new EndUser();
		mockProject=new Project();
		mockReportStatus=new ReportStatus();
		mockLineItem=new LineItem();
		mockType=new Type();
		mockReport=new Report();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);		
	}
	
	@Test
	public void addTest() {
		//Integer id=mockReport.getEndUser().getUserId();
		TypedQuery<EndUser> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(EndUser.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		//verify(mockTypedQuery,times(1)).getSingleResult();
		//mockEndUser=(EndUser) mockTypedQuery;
		TypedQuery<Project> mockTypedProjectQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedProjectQuery);
		when(mockTypedProjectQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedProjectQuery);
		//verify(mockTypedProjectQuery,times(1)).getSingleResult();
		//mockProject=(Project) mockTypedProjectQuery;
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		//verify(mockTypedReportQuery,times(1)).getSingleResult();
		//mockReport=(Report) mockTypedReportQuery;
		//mockReport.setEndUser(mockEndUser);
		//mockReport.setProject(mockProject);
		//mockReport.setReportStatus(mockReportStatus);
		//mockReport.getProject().getProjectId();
		//target.add(mockReport);
		//verify(mockEm, times(1)).persist(mockReport);
		Collection<LineItem> lineItems=mockReport.getLineItems();
		TypedQuery<Report> mockTypedReport2Query = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReport2Query);
		when(mockTypedReport2Query.setParameter(anyString(), anyInt())).thenReturn(mockTypedReport2Query);
		//verify(mockTypedReport2Query,times(1)).getSingleResult();
		//mockReport=(Report) mockTypedReport2Query;
		TypedQuery<Type> mockTypedTypeQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Type.class))).thenReturn(mockTypedTypeQuery);
		when(mockTypedTypeQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedTypeQuery);
		//verify(mockTypedTypeQuery,times(1)).getSingleResult();
		//mockType=(Type) mockTypedTypeQuery;
		//mockLineItem.setReport(mockReport);
		//mockLineItem.setType(mockType);
		//verify(mockEm, times(1)).persist(mockLineItem);
		target.add(mockReport);
		
		verify(mockEm, times(1)).persist(mockReport);
	}
}
