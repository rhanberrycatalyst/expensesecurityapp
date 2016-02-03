package com.catalyst.springboot.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.daos.LineItemDao;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.Type;

@Transactional
@Component 
public class LineItemDaoHibernate implements LineItemDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(ArrayList<LineItem> lineItem) {
		for (LineItem item: lineItem){
			Integer reportId = item.getReport().getReportId();
			Report report = em.createQuery("SELECT r FROM Report r WHERE r.reportId = :id", Report.class)
			.setParameter("id", reportId)
			.getSingleResult();
			
			Integer typeId = item.getType().getTypeId();
			System.out.println(typeId);
			Type type = em.createQuery("SELECT t FROM Type t WHERE t.typeId = :id", Type.class)
			.setParameter("id", typeId)
			.getSingleResult();
			
			item.setReport(report);
			item.setType(type);
			em.persist(item);		
		}
	}

	@Override
	public List<LineItem> getAllLineItemsByReportId(Integer reportId) {
		
		return em.createQuery("SELECT l FROM LineItem l WHERE l.reportId = :id", LineItem.class)
				.setParameter("id", reportId)
				.getResultList();
	}

	@Override
	public LineItem getByLineItemId(Integer lineItemId) {	
		return em.createQuery("SELECT l FROM LineItem l WHERE l.userId = :id", LineItem.class)
				.setParameter("id", lineItemId)
				.getSingleResult();	 
	}

	@Override
	public LineItem getLineItemByLineItemname(String lineItemname){
		return em.createQuery("SELECT l FROM lineItem l WHERE l.lineItemname = :lineItemname", LineItem.class)
				 .setParameter("lineItemname", lineItemname)
				 .getSingleResult();
	}
	@Override
	public void update(LineItem lineItem) { 
		em.merge(lineItem);
	}

	@Override
	public void delete(Integer lineItemId) {
		LineItem lineItem = em.createQuery("SELECT l FROM lineItem l WHERE l.lineItemname = :lineItemname", LineItem.class)
				 .setParameter("lineItemname", lineItemId)
				 .getSingleResult();
		em.remove(lineItem);
		
	}

}
