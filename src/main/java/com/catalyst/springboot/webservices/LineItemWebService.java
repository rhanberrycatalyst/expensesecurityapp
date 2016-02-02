package com.catalyst.springboot.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.services.LineItemService;
import com.catalyst.springboot.services.InvalidInputException;

@RestController
public class LineItemWebService implements LineItemService {
	
	@Autowired
	private LineItemService lineItemService;
	
	public void setlineItemService(LineItemService lineItemService) {
		this.lineItemService = lineItemService;
	}

	@RequestMapping(value="/lineitems", method=RequestMethod.POST)
	public void add(@RequestBody ArrayList<LineItem> lineItem){
		lineItemService.add(lineItem);
	} 
		
		
	@RequestMapping(value="/lineitems", method = RequestMethod.GET)
	public List<LineItem> getLineItems(){
		return lineItemService.getLineItems();
	}	
	
	@RequestMapping(value="/lineitems/{id}", method=RequestMethod.GET)
	public LineItem getByLineItemId(@PathVariable Integer id) throws InvalidInputException{ 
		return lineItemService.getByLineItemId(id);
	}
	
	@RequestMapping(value="/lineitems/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody LineItem lineItem){
		lineItemService.update(lineItem);
	}

	@Override
	public void delete(Integer lineItemId) {
		// TODO Auto-generated method stub
		
	}

}
