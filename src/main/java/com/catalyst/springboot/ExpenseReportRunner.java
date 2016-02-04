package com.catalyst.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This Application allows developers to fill out expense reports. In order to do so, at least one person
 * must have administrator privileges and create projects - setting a technical lead and developers -
 *  to which the expense reports can attach.
 * @author ldahlberg
 * @author gwalpole
 * @author bboyd
 * @author rhanberry
 * @author apaulose
 *
 */
@SpringBootApplication
public class ExpenseReportRunner {
 
	/**
	 * Runs the program
	 */
	public static void main(String[] args) {  
		SpringApplication.run(ExpenseReportRunner.class);
	}

}
