package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


/**
 * An object representing individual lineItems in the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class LineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lineItemId;
	
	@ManyToOne
	@JoinColumn(name="reportid")
	private Report report;
	
	@ManyToOne
	@JoinColumn(name="typeid")
	private Type type;
	@NotNull
	private Double value;

	/**
	 * Generic getter for LineItemId
	 * @return lineItemId
	 */
	public Integer getLineItemId() {
		return lineItemId;
	}
	/**
	 * Generic setter for LineItemId
	 * @param lineItemId
	 */
	public void setLineItemId(Integer lineItemId) {
		this.lineItemId = lineItemId;
	}

	/**
	 * Generic setter for report
	 * @param report
	 */
	public void setReport(Report report) {
		this.report = report;
	}

	/**
	 * Generic getter for type
	 * @return type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Generic setter for type
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Generic getter for value
	 * @return value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * Generic setter for lineItem value
	 * @param value.
	 */
	public void setValue(Double value) {
		this.value = value;
	}
}
