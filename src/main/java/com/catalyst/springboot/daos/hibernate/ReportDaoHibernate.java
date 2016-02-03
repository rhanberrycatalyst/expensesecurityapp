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
	}

	@Override
	public List<Report> getAllReportsByUserId(Integer userId) {
		
		return em.createQuery("SELECT r FROM Report r WHERE r.userId = :id", Report.class)
				.setParameter("id", userId)
				.getResultList();
	}

	@Override
	public Report getByReportId(Integer reportId) {
		return em.createQuery("SELECT r FROM Report r WHERE reportId = :id", Report.class)
				.setParameter("id", reportId)
				.getSingleResult(); 
	}

	@Override
	public Report getReportByReportname(String reportname){
		return em.createQuery("SELECT r FROM Report r WHERE r.name = :reportname", Report.class)
				 .setParameter("reportname", reportname)
				 .getSingleResult();
	}

	@Override
	public void update(Report report) { 
		em.merge(report);
	}


}
