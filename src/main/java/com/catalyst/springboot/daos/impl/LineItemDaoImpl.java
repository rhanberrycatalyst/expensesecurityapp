package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.LineItemDao;
import com.catalyst.springboot.entities.LineItem;

public class LineItemDaoImpl implements LineItemDao{
	
	private List<LineItem> lineItems = new ArrayList<>();
	//private Integer nextId = 1;
	
	@Override
	public void add(ArrayList<LineItem> lineItem) {
		/*lineItem.setLineItemId(nextId);
		nextId++;*/
		lineItems =lineItem ;
		
	}
	
	@Override
	public void update(LineItem lineItem) {
		Integer index = lineItems.indexOf(lineItem);
		lineItems.set(index, lineItem);
	}
	
	
	@Override
	public List<LineItem> getAllLineItemsByReportId(Integer reportId) { 
		return lineItems;
	}
	
	@Override
	public LineItem getByLineItemId(Integer lineItemId) {
		for(LineItem p : lineItems){
			if(p.getLineItemId().equals(lineItemId)){
				return p;
			}
		}
		return null;
	}

	@Override
	public LineItem getLineItemByLineItemname(String lineItemname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer lineItemId) {
		lineItems.remove(lineItemId);
		
	}
}
