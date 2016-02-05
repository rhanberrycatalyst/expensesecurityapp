package com.catalyst.springboot.daos.impl;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.Project;

/**
 * The class <code>ProjectDaoImplTest</code> contains tests for the class <code>{@link ProjectDaoImpl}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:52 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ProjectDaoImplTest {
	/**
	 * Run the ProjectDaoImpl() constructor test.
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testProjectDaoImpl_1()
		throws Exception {
		ProjectDaoImpl result = new ProjectDaoImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void add(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		Project project = new Project();

		fixture.add(project);

		// add additional test code here
	}

	/**
	 * Run the List<Project> getAllProjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetAllProjects_1()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());

		List<Project> result = fixture.getAllProjects();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the Project getByProjectId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetByProjectId_1()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		Integer projectId = new Integer(1);

		Project result = fixture.getByProjectId(projectId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(new Integer(1), result.getProjectId());
		assertEquals(null, result.getEndUsers());
		assertEquals(null, result.getTechId());
	}

	/**
	 * Run the Project getByProjectId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetByProjectId_2()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		Integer projectId = new Integer(1);

		Project result = fixture.getByProjectId(projectId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(new Integer(1), result.getProjectId());
		assertEquals(null, result.getEndUsers());
		assertEquals(null, result.getTechId());
	}

	/**
	 * Run the Project getByProjectId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetByProjectId_3()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		Integer projectId = new Integer(1);

		Project result = fixture.getByProjectId(projectId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(new Integer(1), result.getProjectId());
		assertEquals(null, result.getEndUsers());
		assertEquals(null, result.getTechId());
	}

	/**
	 * Run the Project getProjectByProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetProjectByProjectName_1()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		String projectName = "";

		Project result = fixture.getProjectByProjectName(projectName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.impl.ProjectDaoImpl.getProjectByProjectName(ProjectDaoImpl.java:69)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetProjectByProjectName_2()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		String projectName = "";

		Project result = fixture.getProjectByProjectName(projectName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.impl.ProjectDaoImpl.getProjectByProjectName(ProjectDaoImpl.java:69)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetProjectByProjectName_3()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		String projectName = "";

		Project result = fixture.getProjectByProjectName(projectName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.impl.ProjectDaoImpl.getProjectByProjectName(ProjectDaoImpl.java:69)
		assertNotNull(result);
	}

	/**
	 * Run the void update(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		ProjectDaoImpl fixture = new ProjectDaoImpl();
		fixture.add(new Project());
		Project project = new Project();

		fixture.update(project);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: -1
		//       at java.util.ArrayList.elementData(Unknown Source)
		//       at java.util.ArrayList.set(Unknown Source)
		//       at com.catalyst.springboot.daos.impl.ProjectDaoImpl.update(ProjectDaoImpl.java:36)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProjectDaoImplTest.class);
	}
}