package com.catalyst.springboot.entities;

import java.util.Collection<com.catalyst.springboot.entities.EndUser>;
import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.datagen.relation.*;
import com.bm.testsuite.BaseEntityFixture;

/**
 * The class <code>ProjectTest</code> contains tests for the class <code>{@link Project}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:54 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ProjectTest extends BaseEntityFixture<Project> 
 {
	/**
	 * Generators to generate the entities specified in the mapping. 
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	private static final Generator[] SPECIAL_GENERATORS = { 
			 new MyEndUserCreator(), new MyEndUser>Creator()
		 };
	
	/**
	 * Initialize a newly create test instance to have the given name.
	 *
	 * @param name the name of the test
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	public ProjectTest() {
		super(Project.class, SPECIAL_GENERATORS);
	}

	/**
	 * Bean Generator Class
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	@GeneratorType(className = EndUser.class)
	private static final class MyEndUserCreator extends SingleBeanGenerator<EndUser>
	 {
		private MyEndUserCreator() 
		 {
			super(EndUser.class);
		}
	}

	/**
	 * Bean Generator Class
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	@GeneratorType(className = EndUser>.class)
	private static final class MyEndUser>Creator extends SingleBeanGenerator<EndUser>>
	 {
		private MyEndUser>Creator() 
		 {
			super(EndUser>.class);
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
		junit.textui.TestRunner.run(ProjectTest.class);
	}
}