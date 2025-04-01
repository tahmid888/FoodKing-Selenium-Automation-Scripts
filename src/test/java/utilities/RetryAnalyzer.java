package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//import utilities.RetryCountIfFailed;

public class RetryAnalyzer implements IRetryAnalyzer {

	// int counter = 0;
	// int retryLimit = 2;

	int retryCount = 0;
	int maxRetryCount = 2;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * This method decides how many times a test needs to be rerun. TestNg will call
	 * this method every time a test fails. So we can put some code in here to
	 * decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried and false
	 * it not.
	 *
	 */

	@Override
	public boolean retry(ITestResult result) {

		// For Custom Retry Failed Tests

//		RetryCountIfFailed annotation = result.getMethod().getConstructorOrMethod().getMethod()
//				.getAnnotation(RetryCountIfFailed.class);
//		
//		if ((annotation != null) && (counter < annotation.value())) {
//			counter++;
//			return true;
//		}
//		return false;

		// if (counter < retryLimit) {
		// counter++;
		// return true;
		// }
		// return false;

		if (!result.isSuccess()) { // Check if test is failed

			if (retryCount < maxRetryCount) { // Check if the maximum number of test execution is reached
				System.out.println(
						"Retrying Test : Re-running " + result.getName() + " for " + (retryCount + 1) + " time(s)."); // Print
																														// the
																														// number
																														// of
																														// Retry
																														// attempts

				retryCount++; // Increase the maxRetryCount by 1

				result.setStatus(ITestResult.FAILURE); // Mark test as failed
				return true; // Rerun the failed test
			} else {
				result.setStatus(ITestResult.FAILURE); // TestNG marks last run as failed, if last run is max retry
			}
		} else {
			result.setStatus(ITestResult.SUCCESS); // TestNG parks test as passed when the test test passes

		}

		return false;
	}
}