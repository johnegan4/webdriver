package testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.testng.annotations.Test;



/******************************************************
 * APIDSM end to end regression testing
 */

@RunWith(Suite.class)
@SuiteClasses({ APIDSMTest.class })
public class ApiDsmE2ESuiteRunnerTest {
	@Test
	public void printClass() {
		System.out.println("Testing TestNG Run");
	}
}
