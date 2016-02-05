package com.catalyst.springboot.entities;

import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.datagen.relation.*;
import com.bm.testsuite.BaseEntityFixture;

/**
 * The class <code>LineItemTest</code> contains tests for the class <code>{@link LineItem}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:54 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class LineItemTest extends BaseEntityFixture<LineItem> 
 {
	/**
	 * Generators to generate the entities specified in the mapping. 
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	private static final Generator[] SPECIAL_GENERATORS = { 
			 new MyReportCreator(), new MyTypeCreator()
		 };
	
	/**
	 * Initialize a newly create test instance to have the given name.
	 *
	 * @param name the name of the test
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	public LineItemTest() {
		super(LineItem.class, SPECIAL_GENERATORS);
	}

	/**
	 * Bean Generator Class
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	@GeneratorType(className = Report.class)
	private static final class MyReportCreator extends SingleBeanGenerator<Report>
	 {
		private MyReportCreator() 
		 {
			super(Report.class);
		}
	}

	/**
	 * Bean Generator Class
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	@GeneratorType(className = Type.class)
	private static final class MyTypeCreator extends SingleBeanGenerator<Type>
	 {
		private MyTypeCreator() 
		 {
			super(Type.class);
		}
	}



	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(LineItemTest.class);
	}
}