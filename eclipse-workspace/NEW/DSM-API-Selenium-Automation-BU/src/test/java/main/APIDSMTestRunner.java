package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testcases.ApiDsmE2ESuiteRunnerTest;





 



/**
 * DSM main method to invoke the tests 
 */
public class APIDSMTestRunner {

	public static void main(String[] args) {
		System.out.println("ApiDsmTestRunner");

		Result result = JUnitCore.runClasses(ApiDsmE2ESuiteRunnerTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Api dsm Test Failures ->"+failure.toString());
		}

		System.out.println("Api Dsm Test Success ->"+result.wasSuccessful());
	}
}
