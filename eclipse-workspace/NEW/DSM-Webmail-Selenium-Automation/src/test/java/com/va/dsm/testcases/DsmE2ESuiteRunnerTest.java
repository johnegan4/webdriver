package com.va.dsm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * EPRS end to end regression testing
 */

@RunWith(Suite.class)
@SuiteClasses({ DsmE2ETest.class })
public class DsmE2ESuiteRunnerTest {
	@Test
	public void printClass() {
		System.out.println("Testing TestNG Run");
	}
}
