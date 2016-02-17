package com.catalyst.springboot.daos.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		when( mockEm.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)).thenReturn(mockTypedQuery);
		//when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		//verify(mockTypedQuery,times(1)).getSingleResult();
		mockEndUser=(EndUser) mockTypedQuery;
		TypedQuery<Project> mockTypedProjectQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT p FROM Project p WHERE p.projectId = :id", Project.class)).thenReturn(mockTypedProjectQuery);
		//when(mockTypedProjectQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedProjectQuery);
		//verify(mockTypedProjectQuery,times(1)).getSingleResult();
		mockProject=(Project) mockTypedProjectQuery;
		TypedQuery<ReportStatus> mockTypedReportStatusQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT s FROM ReportStatus s WHERE s.reportStatusId = 1", ReportStatus.class)).thenReturn(mockTypedReportStatusQuery);
		//when(mockTypedReportStatusQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		//verify(mockTypedReportStatusQuery,times(1)).getSingleResult();
		mockReport=(Report) mockTypedReportStatusQuery;
		mockReport.setEndUser(mockEndUser);
		mockReport.setProject(mockProject);
		mockReport.setReportStatus(mockReportStatus);
		mockReport.getProject().getProjectId();
		target.add(mockReport);
		verify(mockEm, times(1)).persist(mockReport);
		
		Collection<LineItem> lineItems=mockReport.getLineItems();
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT r FROM Report r WHERE r.reportId = :id", Report.class)).thenReturn(mockTypedReportQuery);
		//when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		//verify(mockTypedReportQuery,times(1)).getSingleResult();
		mockReport=(Report) mockTypedReportQuery;
		TypedQuery<Type> mockTypedTypeQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT t FROM Type t WHERE t.typeId = :id", Type.class)).thenReturn(mockTypedTypeQuery);
		//when(mockTypedTypeQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedTypeQuery);
		//verify(mockTypedTypeQuery,times(1)).getSingleResult();
		mockType=(Type) mockTypedTypeQuery;
		mockLineItem.setReport(mockReport);
		mockLineItem.setType(mockType);
		verify(mockEm, times(1)).persist(mockLineItem);
		
		
		verify(mockEm, times(1)).persist(mockReport);
	}
	
	@Test
	public void getAllReportsByUserIdTest(){
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);	
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		target.getAllReportsByUserId(0);
		verify(mockTypedReportQuery, times(1)).setParameter(eq("id"), eq(0));	
		}
	@Test
	public void getByReportIdTest(){
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);	
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		target.getByReportId(0);
		verify(mockTypedReportQuery, times(1)).setParameter(eq("id"), eq(0));	
	}
	@Test
	public void getReportByReportnameTest(){
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);	
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedReportQuery);
		target.getReportByReportname("reportname");
		verify(mockTypedReportQuery, times(1)).setParameter(eq("reportname"), eq("reportname"));
	}
	@Test
	public void updateTest(){
		
		target.update(mockReport);
		verify(mockEm, times(1)).merge(mockReport);
	}
	@Test
	public void getSubmittedReportsByProjectsTest(){
		List<Report> expected = new ArrayList<>();
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);	
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedReportQuery);	
		Project[] projectList ={};
		target.getSubmittedReportsByProjects(projectList);
		when(mockTypedReportQuery.getResultList()).thenReturn(expected);
	}
	@Test
	public void updateToSubmitTest(){
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);	
		when(mockEm.createQuery("SELECT r FROM Report r WHERE r.reportId = :id", Report.class)).thenReturn(mockTypedReportQuery);
		//when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);	
		//mockReport=(Report) mockTypedReportQuery;
		TypedQuery<ReportStatus> mockTypedReportStatusQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT s FROM ReportStatus s WHERE s.reportStatusId = 2", ReportStatus.class)).thenReturn(mockTypedReportStatusQuery);
		//when(mockTypedReportStatusQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportStatusQuery);
		//mockReportStatus=(ReportStatus) mockTypedReportStatusQuery;
		//mockReport.setReportStatus(mockReportStatus);
		target.updateToSubmit(1);
		verify(mockEm, times(1)).merge(mockReport);
	}
}
