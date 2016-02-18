package com.catalyst.springboot.daos.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;
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

import com.catalyst.springboot.entities.Type;

public class ReportDaoHibernateTest {
	private ReportDaoHibernate target;
	private Report mockReport;
	private EndUser mockEndUser;
	private Project mockProject;
	private ReportStatus mockReportStatus;
	private Type mockType;
	private EntityManager mockEm;

	/**
	 * set up the playing field.
	 */
	@Before
	public void setup() {
		target = new ReportDaoHibernate();
		mockEndUser = new EndUser();
		mockProject = new Project();
		mockReportStatus = new ReportStatus();
		mockType = new Type();
		mockReport = new Report();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	/**
	 * a test for adding the report
	 */
	@Test
	public void addTest() {
		Report mockReport = mock(Report.class);
		EndUser mockReportEndUser = mock(EndUser.class);
		when(mockReport.getEndUser()).thenReturn(mockReportEndUser);
		when(mockReportEndUser.getUserId()).thenReturn(1);
		TypedQuery<EndUser> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class))
				.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter("id", 1)).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(mockEndUser);
		Project mockProject1 = mock(Project.class);
		when(mockReport.getProject()).thenReturn(mockProject1);
		when(mockProject1.getProjectId()).thenReturn(1);
		TypedQuery<Project> mockTypedProjectQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT p FROM Project p WHERE p.projectId = :id", Project.class))
				.thenReturn(mockTypedProjectQuery);
		when(mockTypedProjectQuery.setParameter("id", 1)).thenReturn(mockTypedProjectQuery);
		when(mockTypedProjectQuery.getSingleResult()).thenReturn(mockProject);
		TypedQuery<ReportStatus> mockTypedReportStatusQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT s FROM ReportStatus s WHERE s.reportStatusId = 1", ReportStatus.class))
				.thenReturn(mockTypedReportStatusQuery);
		when(mockTypedReportStatusQuery.getSingleResult()).thenReturn(mockReportStatus);
		mockReport.setEndUser(mockEndUser);
		mockReport.setProject(mockProject);
		mockReport.setReportStatus(mockReportStatus);
		Report mockReport1 = mock(Report.class);
		when(mockReport.getReportId()).thenReturn(1);
		Collection<LineItem> lineItems = mockReport.getLineItems();
		LineItem mockItem = mock(LineItem.class);
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT r FROM Report r WHERE r.reportId = :id", Report.class))
				.thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter("id", 1)).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.getSingleResult()).thenReturn(mockReport1);
		Type mockType1 = mock(Type.class);
		when(mockItem.getType()).thenReturn(mockType1);
		when(mockType1.getTypeId()).thenReturn(1);
		TypedQuery<Type> mockTypedTypeQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT t FROM Type t WHERE t.typeId = :id", Type.class))
				.thenReturn(mockTypedTypeQuery);
		when(mockTypedTypeQuery.setParameter("id", 1)).thenReturn(mockTypedTypeQuery);
		when(mockTypedTypeQuery.getSingleResult()).thenReturn(mockType);
		mockItem.setReport(mockReport1);
		mockItem.setType(mockType);
		target.add(mockReport);
		verify(mockEm, times(1)).persist(mockReport);

	}

	/**
	 * a test for getting the reports belongs to a user
	 */

	@Test
	public void getAllReportsByUserIdTest() {
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		target.getAllReportsByUserId(0);
		verify(mockTypedReportQuery, times(1)).setParameter(eq("id"), eq(0));
	}

	/**
	 * a test for getting the report by passing reportId
	 */
	@Test
	public void getByReportIdTest() {
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedReportQuery);
		target.getByReportId(0);
		verify(mockTypedReportQuery, times(1)).setParameter(eq("id"), eq(0));
	}

	/**
	 * a test for getting the report by passing reportName
	 */
	@Test
	public void getReportByReportnameTest() {
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedReportQuery);
		target.getReportByReportname("reportname");
		verify(mockTypedReportQuery, times(1)).setParameter(eq("reportname"), eq("reportname"));
	}

	/**
	 * a test for updating a report
	 */

	@Test
	public void updateTest() {

		target.update(mockReport);
		verify(mockEm, times(1)).merge(mockReport);
	}

	/**
	 * a test for getting the reports by passing a list of projects
	 */

	@Test
	public void getSubmittedReportsByProjectsTest() {
		List<Report> expected = new ArrayList<>();
		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedReportQuery);
		Project[] projectList = {};
		target.getSubmittedReportsByProjects(projectList);
		when(mockTypedReportQuery.getResultList()).thenReturn(expected);
	}

	/**
	 * a test for updating the report status to submit
	 */
	@Test
	public void updateToSubmitTest() {

		TypedQuery<Report> mockTypedReportQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT r FROM Report r WHERE r.reportId = :id", Report.class))
				.thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.setParameter("id", 1)).thenReturn(mockTypedReportQuery);
		when(mockTypedReportQuery.getSingleResult()).thenReturn(mockReport);

		TypedQuery<ReportStatus> mockTypedReportStatusQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT s FROM ReportStatus s WHERE s.reportStatusId = 2", ReportStatus.class))
				.thenReturn(mockTypedReportStatusQuery);
		when(mockTypedReportStatusQuery.getSingleResult()).thenReturn(mockReportStatus);

		mockReport.setReportStatus(mockReportStatus);
		target.updateToSubmit(1);
		verify(mockEm, times(1)).merge(mockReport);

	}
}
