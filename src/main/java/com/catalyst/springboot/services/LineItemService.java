package com.catalyst.springboot.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.entities.LineItem;

public interface LineItemService {
	/**
	 * Add a new lineItem to the application.
	 * 
	 * @param lineItem
	 */
	void add(ArrayList<LineItem> lineItem);

	/**
	 * Update the information in an existing lineItem. The lineItemId is used to
	 * find the unique lineItem's information.
	 * 
	 * @param lineItem
	 */
	void update(LineItem lineItem);
	
	/**
	 * Removes the information about a lineItem from the application if their
	 * lineItemId matches.
	 * 
	 * @param lineItemId
	 *            -
	 */
	void delete(Integer lineItemId);


	/**
	 * Retrieve all lineItems from the application.
	 * 
	 * @param isActive
	 *            - optional parameter. If supplied, will only retrieve
	 *            lineItems with matching values. If null, all lineItems are
	 *            returned.
	 * @return
	 */
	
	
	List<LineItem> getAllLineItemsByReportId(Integer reportId);

	/**
	 * Retrieve a single lineItem's information if that lineItem's lineItemId
	 * matches the supplied lineItemId
	 * 
	 * @param lineItemId
	 * @return
	 * @throws InvalidInputException
	 *             - the value of lineItemId provided should not be null or less
	 *             than 0
	 */
	LineItem getByLineItemId(Integer lineItemId) throws InvalidInputException;


}
