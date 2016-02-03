package com.catalyst.springboot.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportStatus;

@Transactional
@Component
public class ReportDaoHibernate implements ReportDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(Report report) {
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
		
	}

	@Override
	public List<Report> getAllReports() {
		
		return em.createQuery("SELECT p FROM Report p", Report.class).
				getResultList();
	}

	@Override
	public Report getByReportId(Integer reportId) {	
		return em.createQuery("SELECT p FROM Report p WHERE p.reportId = :id", Report.class)
				.setParameter("id", reportId)
				.getSingleResult();	 
	}

	@Override
	public Report getReportByReportname(String reportname){
		return em.createQuery("SELECT p FROM Report p WHERE p.reportname = :reportname", Report.class)
				 .setParameter("reportname", reportname)
				 .getSingleResult();
	}
	@Override
	public void update(Report report) { 
		em.merge(report);
	}


}
