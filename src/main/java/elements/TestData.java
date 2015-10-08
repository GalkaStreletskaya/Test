package elements;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "test_1")
	public static Object[][] emailInvalidData() {
	 return new Object[][] {
	   { "Abc.example.com", "A '@' character must separate the local and domain parts!" },
	   { "A@b@c@example.com", "Only one '@' symbol is allowed!" },
	   { "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", "None of the special characters in local part are allowed outside quotation marks!" },
	   { "just\"not\"right@example.com", "Quoted strings must be dot separated or the only element making up the local-part!" },
	   { "john..doe@example.com", "Double dot is not allowed before '@' symbol!" },
	   { "john.doe@example..com", "Double dot is not allowed after '@' symbol!" },
	   { "abc", "Email address should match current format: username@domain." }
	 };
	}
}