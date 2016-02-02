package com.catalyst.springboot.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.entities.LineItem;

/**
 * The methods declared in this interface are to provide basic CRUD functionality related to lineItem objects.
 * @author Ernest
 *
 */
public interface LineItemDao {

		/**
		 * Adds information about an lineItem to storage.
		 * @param lineItem
		 */
		void add(ArrayList<LineItem> lineItem);

		/**
		 * Updates the information about an lineItem already in storage.
		 * @param lineItem
		 */
		void update(LineItem lineItem);
		
		/**
		 * Retrieves all lineItems currently in storage.
		 * @return
		 */
		List<LineItem> getAllLineItems();
		
		/**
		 * Retrieve information about a single lineItem from storage with a matching lineItemId
		 * @param lineItemId
		 * @return
		 */
		LineItem getByLineItemId(Integer lineItemId);
		
		/**
		 * Deletes information about an lineItem with a matching lineItemId
		 * @param lineItemId
		 */
		void delete(Integer lineItemId);

		/**
		 * Retrieves an lineItem with a matching lineItemname.
		 * 
		 * @param lineItemname
		 * @return
		 */
		LineItem getLineItemByLineItemname(String lineItemname);

}
