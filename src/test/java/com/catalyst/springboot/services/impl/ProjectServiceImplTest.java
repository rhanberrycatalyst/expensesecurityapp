package com.catalyst.springboot.services.impl;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.daos.ProjectDao;
import com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.InvalidInputException;

/**
 * The class <code>ProjectServiceImplTest</code> contains tests for the class <code>{@link ProjectServiceImpl}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:55 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ProjectServiceImplTest {
	/**
	 * Run the void add(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		Project project = new Project();

		fixture.add(project);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.add(ProjectDaoHibernate.java:41)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.add(ProjectServiceImpl.java:48)
	}

	/**
	 * Run the Project getByProjectId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetByProjectId_1()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		Integer projectId = new Integer(1);

		Project result = fixture.getByProjectId(projectId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.getByProjectId(ProjectDaoHibernate.java:67)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getByProjectId(ProjectServiceImpl.java:72)
		assertNotNull(result);
	}

	/**
	 * Run the Project getByProjectId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetByProjectId_2()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		Integer projectId = new Integer(1);

		Project result = fixture.getByProjectId(projectId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.getByProjectId(ProjectDaoHibernate.java:67)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getByProjectId(ProjectServiceImpl.java:72)
		assertNotNull(result);
	}

	/**
	 * Run the Project getByProjectId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test(expected = com.catalyst.springboot.services.InvalidInputException.class)
	public void testGetByProjectId_3()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		Integer projectId = null;

		Project result = fixture.getByProjectId(projectId);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjectByProjectName_1()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		String projectName = "";

		Project result = fixture.getProjectByProjectName(projectName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.getProjectByProjectName(ProjectDaoHibernate.java:79)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getProjectByProjectName(ProjectServiceImpl.java:87)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjectByProjectName_2()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		String projectName = "";

		Project result = fixture.getProjectByProjectName(projectName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.getProjectByProjectName(ProjectDaoHibernate.java:79)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getProjectByProjectName(ProjectServiceImpl.java:87)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test(expected = com.catalyst.springboot.services.InvalidInputException.class)
	public void testGetProjectByProjectName_3()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		String projectName = null;

		Project result = fixture.getProjectByProjectName(projectName);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<Project> getProjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjects_1()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());

		List<Project> result = fixture.getProjects();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.getAllProjects(ProjectDaoHibernate.java:56)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getProjects(ProjectServiceImpl.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the void setProjectDao(ProjectDao) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetProjectDao_1()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		ProjectDao projectDao = new ProjectDaoHibernate();

		fixture.setProjectDao(projectDao);

		// add additional test code here
	}

	/**
	 * Run the void update(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		ProjectServiceImpl fixture = new ProjectServiceImpl();
		fixture.setProjectDao(new ProjectDaoHibernate());
		Project project = new Project();

		fixture.update(project);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ProjectDaoHibernate.update(ProjectDaoHibernate.java:90)
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.update(ProjectServiceImpl.java:57)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
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
	 * @generatedBy CodePro at 2/5/16 11:55 AM
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
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProjectServiceImplTest.class);
	}
}