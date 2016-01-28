package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	private Double value;

	public Integer getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Integer lineItemId) {
		this.lineItemId = lineItemId;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
