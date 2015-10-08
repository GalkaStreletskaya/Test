package galka.streletskaya.myProject;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import elements.TestConstants;


public class Driver {
	
	private WebDriver driver;
	
	public Driver() {
		System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + File.separator + "src" + "\\chromedriver\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("chrome.binary", "test-type", "--start-maximized", "allow-running-insecure-content", "ignore-certificate-errors"));
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void navigateTo(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public void getDriverWait(String elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, TestConstants.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementLocator)));
	}
	
	public void getDriverWaitForEnabled(String elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, TestConstants.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementLocator)));
	}
	
	public void getDriverWaitForDisabled(String elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, TestConstants.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elementLocator)));
	}
	
	public WebElement getElement(String elementSelector) throws TimeoutException {
		WebElement webElement = null;
		getDriverWait(elementSelector);
		webElement = driver.findElement(By.cssSelector(elementSelector));
		return webElement;
	}
}