package Pages;

import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import elements.TestConstants;
import galka.streletskaya.myProject.Driver;

public class BasePage {
	
	protected Driver driver;
	private String url = TestConstants.BASE_URL;
	
	public BasePage() {
		driver = new Driver();
	}
	
	public BasePage(Driver driver) {
		this.driver = driver;
	}
	
	public void open() throws Exception {
		driver.navigateTo(url);
		waitForPageToLoad();
	}
	
	public void quit() {
		driver.quit();
	}
	
    public WebElement findElement(String element) throws TimeoutException {
    	WebElement webElement = null;
    	webElement = driver.getElement(element);
        return webElement;
    }
    
    public void type(String fieldLocator, String insertText) throws Exception {
    	WebElement element = findElement(fieldLocator);
    	waitForElementPresent(fieldLocator);
    	element.clear();
    	element.sendKeys(insertText);
    }
    
    public void click(String buttonLocator) throws TimeoutException {
    	WebElement element = findElement(buttonLocator);
    	element.click();
    }
    
    public void waitForPageToLoad() {
    	WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), TestConstants.DEFAULT_TIMEOUT);
		wait.until(new Function<WebDriver, Boolean>() {
    		public Boolean apply(WebDriver driver) {
    			return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete");
    		}
    	});
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loading']")));
    }
    
    public void waitForElementPresent(String elementLocator) throws Exception {
    	driver.getDriverWait(elementLocator);
    }
    
    public void waitForElementToBeEnabled(String elementLocator) throws Exception {
    	driver.getDriverWaitForEnabled(elementLocator);
    }
    
    public void waitForElementToBeDisabled(String elementLocator) throws Exception {
    	driver.getDriverWaitForDisabled(elementLocator);
    }

    public String getText(String elementLocator) throws Exception {
    	WebElement element = findElement(elementLocator);
    	String text = element.getText();
		return text;
    }
    
	public boolean isElementPresent(String locator) throws TimeoutException {
	    try {
	    	findElement(locator);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	public boolean isElementEnabled(String locator, String attribute) throws TimeoutException {
		try {
			findElement(locator).getAttribute(attribute);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isElementDisplayed(String locator) throws Exception {
		try {
			driver.getWebDriver().findElement(By.cssSelector(locator)).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}

	
