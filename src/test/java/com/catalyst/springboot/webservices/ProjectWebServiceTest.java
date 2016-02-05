package com.catalyst.springboot.webservices;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.ProjectService;
import com.catalyst.springboot.services.impl.ProjectServiceImpl;

/**
 * The class <code>ProjectWebServiceTest</code> contains tests for the class <code>{@link ProjectWebService}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:55 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ProjectWebServiceTest {
	/**
	 * Run the void addProject(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testAddProject_1()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		Project project = new Project();

		fixture.addProject(project);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.add(ProjectServiceImpl.java:48)
		//       at com.catalyst.springboot.webservices.ProjectWebService.addProject(ProjectWebService.java:41)
	}

	/**
	 * Run the Project getProjectByID(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjectByID_1()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		Integer id = new Integer(1);

		Project result = fixture.getProjectByID(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getByProjectId(ProjectServiceImpl.java:72)
		//       at com.catalyst.springboot.webservices.ProjectWebService.getProjectByID(ProjectWebService.java:60)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByID(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjectByID_2()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		Integer id = new Integer(1);

		Project result = fixture.getProjectByID(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getByProjectId(ProjectServiceImpl.java:72)
		//       at com.catalyst.springboot.webservices.ProjectWebService.getProjectByID(ProjectWebService.java:60)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjectByName_1()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		String name = "";

		Project result = fixture.getProjectByName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getProjectByProjectName(ProjectServiceImpl.java:87)
		//       at com.catalyst.springboot.webservices.ProjectWebService.getProjectByName(ProjectWebService.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the Project getProjectByName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetProjectByName_2()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		String name = "";

		Project result = fixture.getProjectByName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getProjectByProjectName(ProjectServiceImpl.java:87)
		//       at com.catalyst.springboot.webservices.ProjectWebService.getProjectByName(ProjectWebService.java:79)
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
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());

		List<Project> result = fixture.getProjects();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.getProjects(ProjectServiceImpl.java:38)
		//       at com.catalyst.springboot.webservices.ProjectWebService.getProjects(ProjectWebService.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the void setprojectService(ProjectService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetprojectService_1()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		ProjectService projectService = new ProjectServiceImpl();

		fixture.setprojectService(projectService);

		// add additional test code here
	}

	/**
	 * Run the void updateuser(Integer,Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdateuser_1()
		throws Exception {
		ProjectWebService fixture = new ProjectWebService();
		fixture.setprojectService(new ProjectServiceImpl());
		Integer id = new Integer(1);
		Project project = new Project();

		fixture.updateuser(id, project);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ProjectServiceImpl.update(ProjectServiceImpl.java:57)
		//       at com.catalyst.springboot.webservices.ProjectWebService.updateuser(ProjectWebService.java:69)
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
		new org.junit.runner.JUnitCore().run(ProjectWebServiceTest.class);
	}
}