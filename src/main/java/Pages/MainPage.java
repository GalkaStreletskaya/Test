package Pages;

import java.util.concurrent.TimeoutException;

import elements.TestConstants;
import galka.streletskaya.myProject.Driver;
import utils.AssertHandler;

public class MainPage extends BasePage{
	
	AssertHandler assertHandler = new AssertHandler();
	
	public MainPage() throws ClassNotFoundException {
		super();
	}
	
	public MainPage(Driver driver) throws ClassNotFoundException {
		super(driver);
	}
	
	public void insertEmailAddressAndConfirm(String emailAddress) throws Exception {
		type(TestConstants.LOGIN_FIELD, emailAddress);
		click(TestConstants.LOGIN_BUTTON);
	}

	public void verifyInvalidEmailAddressErrorMessage(String expectedErrorMessage) throws Exception {
		String popupText = getText(TestConstants.ERROR_POPUP);
		assertHandler.isConditionTrue("Expected error message: '" + expectedErrorMessage + "', doesn't match the current one: '" + popupText + "'", popupText.equals(expectedErrorMessage));
	}

	public void changeSiteLanguageToDesireableIfItsNotSelected(String languageSign) throws TimeoutException, Exception {
		if(!isElementDisplayed(String.format(TestConstants.SELECTED_LANGUAGE, languageSign))) {
			click(TestConstants.LANGUAGE_LABEL);
			waitForElementToBeEnabled(TestConstants.LANGUAGE_BAR);
			click(String.format(TestConstants.NOT_SELECTED_LANGUAGE, languageSign));
			waitForElementToBeDisabled(TestConstants.LANGUAGE_BAR);
			waitForPageToLoad();
		}
	}
}
