package com.va.dsm.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.va.dsm.testcases.DsmE2ESuiteRunnerTest;


/**
 * EPRS main method to invoke the tests
 */
public class DSMTestRunner {

	public static void main(String[] args) {
		System.out.println("DSMTestRunner");
		Result result = JUnitCore.runClasses(DsmE2ESuiteRunnerTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("DSM Test Failures ->"+failure.toString());
		}

		System.out.println("DSM Test Success ->"+result.wasSuccessful());
	}
}
