package com.catalyst.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.LineItemDao;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.services.InvalidInputException;
import com.catalyst.springboot.services.LineItemService;

@Service
public class LineItemServiceImpl implements LineItemService{

	@Autowired
	private LineItemDao lineItemDao;

	public void setLineItemDao(LineItemDao lineItemDao) {
		this.lineItemDao = lineItemDao;
	}

	@Override
	public List<LineItem> getLineItems() {

		List<LineItem> lineItems = lineItemDao.getAllLineItems();
		return lineItems;
	}

	@Override
	public void add(ArrayList<LineItem> lineItem) {
		lineItemDao.add(lineItem);
	}

	@Override
	public void update(LineItem lineItem) {
		lineItemDao.update(lineItem);
	}

	@Override
	public LineItem getByLineItemId(Integer lineItemId) throws InvalidInputException {
		if (lineItemId == null || lineItemId < 0) {
			throw new InvalidInputException("lineItemId.NullOrNegative");
		}
		return lineItemDao.getByLineItemId(lineItemId);
	}

	@Override
	public void delete(Integer lineItemId) {
		// TODO Auto-generated method stub
		
	}

}
