package utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class AssertHandler {

	private static List<String> errors = null; 

	public AssertHandler(){
		if(errors == null ){
			errors = new ArrayList<String>();
		}
		else errors.clear();
	}

	public void isConditionTrue(String description, boolean condition) throws Exception {
		try {
			Assert.assertTrue(description, condition);
		} catch (AssertionError e) {
			errors.add("Assertion Error has occured:" + e.getMessage());
		}
	}

	public void isConditionFalse(String description, boolean condition) throws Exception {
		try {
			Assert.assertFalse(description, condition);
		} catch (AssertionError e) {
			errors.add("Assertion Error has occured:" + e.getMessage());
		}
	}

	public void assertionFail(String message) {
		try {
			Assert.fail(message);
		} catch (AssertionError e) {
			errors.add("Assertion Fail has occured:" + e.getMessage());
		}
	}

	public void verifyNoAssertionFailed() throws Exception {
		if (!errors.isEmpty())
			throw new Exception("Assertion Error has occured: " + " \n" + errors);
	}
}