package com.catalyst.springboot.daos.hibernate;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportStatus;
import com.catalyst.springboot.entities.Type;

/**
 * The hibernate functionality for the Report's Database access
 * @author ldahlberg
 * @author gwalpole
 */
@Transactional
@Component
public class ReportDaoHibernate implements ReportDao {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Sets EntityManager.
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	/**
	 * Creates a new row in the Report table in the database and updates EndUser and Project tables.
	 * LineItem feature then loops through LineItems and adds new rows to Line Item tables in database.
	 * @param report
	 */
	@Override
	public void add(Report report) {
		try {
			Integer userId = report.getEndUser().getUserId();
			EndUser endUser = em.createQuery("SELECT e FROM EndUser e WHERE e.userId = :id", EndUser.class)
			.setParameter("id", userId)
			.getSingleResult();
			
			Integer projectId = report.getProject().getProjectId();
			Project project = em.createQuery("SELECT p FROM Project p WHERE p.projectId = :id", Project.class)
			.setParameter("id", projectId)
			.getSingleResult();
			
			ReportStatus reportStatus = em.createQuery("SELECT s FROM ReportStatus s WHERE s.reportStatusId = 1", ReportStatus.class)
			.getSingleResult();
			
			report.setEndUser(endUser);
			report.setProject(project);
			report.setReportStatus(reportStatus);
			em.persist(report);
			
			Integer reportValue = report.getReportId();
			Collection<LineItem> lineItems = report.getLineItems();
			for (LineItem item: lineItems){
				Integer reportId = reportValue;
				Report lineReport = em.createQuery("SELECT r FROM Report r WHERE r.reportId = :id", Report.class)
				.setParameter("id", reportId)
				.getSingleResult();
				
				Integer typeId = item.getType().getTypeId();
				System.out.println(typeId);
				Type type = em.createQuery("SELECT t FROM Type t WHERE t.typeId = :id", Type.class)
				.setParameter("id", typeId)
				.getSingleResult();
				
				item.setReport(lineReport);
				item.setType(type);
				em.persist(item);		
			}
		} finally {
			em.close();
		}
		
	}

	/**
	 * @return all Reports assigned to a user with
	 * @param userId
	 */
	@Override
	public List<Report> getAllReportsByUserId(Integer userId) {
		try{
			return em.createQuery("SELECT r FROM Report r WHERE r.endUser.userId = :id", Report.class)
					.setParameter("id", userId)
					.getResultList();
		} finally {
			em.close();
		}
		
	}

	/**
	 * @return single Report with
	 * @param reportId
	 */
	@Override
	public Report getByReportId(Integer reportId) {
		try{
			return em.createQuery("SELECT r FROM Report r WHERE reportId = :id", Report.class)
					.setParameter("id", reportId)
					.getSingleResult(); 
		} finally {
			em.close();
		}
		
	}

	/**
	 * @return single Report with
	 * @param reportName
	 */
	@Override
	public Report getReportByReportname(String reportname){
		try {
			return em.createQuery("SELECT r FROM Report r WHERE r.name = :reportname", Report.class)
					 .setParameter("reportname", reportname)
					 .getSingleResult();
		} finally {
			em.close();
		}
		
	}

	/**
	 * update Report in database with
	 * @param report
	 */
	@Override
	public void update(Report report) { 
		em.merge(report);
	}

	/**
	 * Gets a list of reports with the 'Submitted' status belonging to any of a list of projects passed in. 
	 * @param projectList 
	 * @return
	 */
	@Override
	public List<Report> getSubmittedReportsByProjects(Project[] projectList)
	{
		String projects = "";
		for(Project proj : projectList)
		{
		  projects = projects + "" + proj.getProjectId() + ",";
		}
		if(projects.length() > 0)
		{ //cut off trailing comma
		  projects = projects.substring(0, projects.length()-1); 
		}
		try {
			return em.createQuery("SELECT r FROM Report r WHERE r.project.projectId IN(" + projects + ") AND r.reportStatus.reportStatus = 'Submitted'", Report.class)
					 .getResultList();
		} finally {
			em.close();
		}
	}
}
