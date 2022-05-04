package com.perigon.retryexecution;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.AfterSuite;

public class FailedTestsExecutor {

	@AfterSuite
	public void runFailedXml() {

		TestNG object = new TestNG();
		List<String> failedTests = new ArrayList<String>();
		failedTests
				.add("C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\test-output\\testng-failed.xml");
		object.setTestSuites(failedTests);
		object.run();

	}

}
