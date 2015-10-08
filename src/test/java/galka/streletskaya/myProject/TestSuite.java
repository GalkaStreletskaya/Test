package galka.streletskaya.myProject;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import Pages.MainPage;
import elements.TestData;
import utils.AssertHandler;

@Test
public class TestSuite {
	
	private MainPage mainPage;
	private AssertHandler assertHandler;
	
	@BeforeTest
	public void setUp() throws Exception {
		mainPage = new MainPage();
		assertHandler = new AssertHandler();
	}
	
	@AfterTest
	public void closePage() throws Exception {
		mainPage.quit();
	}
	
	@Test(dataProvider="test_1", dataProviderClass = TestData.class)
	public void Test_01(String emailAddress, String expectedErrorMessage) throws Exception {
		mainPage.open();
		mainPage.changeSiteLanguageToDesireableIfItsNotSelected("EN");
		mainPage.insertEmailAddressAndConfirm(emailAddress);
		mainPage.verifyInvalidEmailAddressErrorMessage(expectedErrorMessage);
		assertHandler.verifyNoAssertionFailed();
	}
	
}
