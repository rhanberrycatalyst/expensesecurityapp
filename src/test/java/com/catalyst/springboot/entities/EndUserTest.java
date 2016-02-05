package com.catalyst.springboot.entities;

import java.util.Collection<com.catalyst.springboot.entities.Project>;
import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.datagen.relation.*;
import com.bm.testsuite.BaseEntityFixture;

/**
 * The class <code>EndUserTest</code> contains tests for the class <code>{@link EndUser}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:54 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class EndUserTest extends BaseEntityFixture<EndUser> 
 {
	/**
	 * Generators to generate the entities specified in the mapping. 
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	private static final Generator[] SPECIAL_GENERATORS = { 
			 new MyProject>Creator(), new MySpringRoleCreator()
		 };
	
	/**
	 * Initialize a newly create test instance to have the given name.
	 *
	 * @param name the name of the test
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	public EndUserTest() {
		super(EndUser.class, SPECIAL_GENERATORS);
	}

	/**
	 * Bean Generator Class
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	@GeneratorType(className = Project>.class)
	private static final class MyProject>Creator extends SingleBeanGenerator<Project>>
	 {
		private MyProject>Creator() 
		 {
			super(Project>.class);
		}
	}

	/**
	 * Bean Generator Class
	 *
	 * @generatedBy CodePro at 2/5/16 11:54 AM
	 */
	@GeneratorType(className = SpringRole.class)
	private static final class MySpringRoleCreator extends SingleBeanGenerator<SpringRole>
	 {
		private MySpringRoleCreator() 
		 {
			super(SpringRole.class);
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
		junit.textui.TestRunner.run(EndUserTest.class);
	}
}