package sdet_capstone.core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumWebActions implements WebActions {

	private WebDriver driver = null;

	@Override
	public void initBrowser(String browserType) {
		switch (browserType.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser type: " + browserType);
		}

		driver.manage().window().maximize();

	}

	@Override
	public void launchUrl(String url) {
		driver.get(url);
	}

	@Override
	public WebElement getElement(String locatorType, String locator) {
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			return driver.findElement(By.xpath(locator));
		case "CSS":
			return driver.findElement(By.cssSelector(locator));
		case "ID":
			return driver.findElement(By.id(locator));
		case "CLASSNAME":
			return driver.findElement(By.className(locator));
		case "NAME":
			return driver.findElement(By.name(locator));
		case "LINKTEXT":
			return driver.findElement(By.linkText(locator));
		case "PARTIALLINKTEXT":
			return driver.findElement(By.partialLinkText(locator));
		case "TAGNAME":
			return driver.findElement(By.tagName(locator));
		default:
			throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
		}
	}

	@Override
	public List<WebElement> getElements(String locatorType, String locator) {
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			return driver.findElements(By.xpath(locator));
		case "CSS":
			return driver.findElements(By.cssSelector(locator));
		case "ID":
			return driver.findElements(By.id(locator));
		case "CLASSNAME":
			return driver.findElements(By.className(locator));
		case "NAME":
			return driver.findElements(By.name(locator));
		case "LINKTEXT":
			return driver.findElements(By.linkText(locator));
		case "PARTIALLINKTEXT":
			return driver.findElements(By.partialLinkText(locator));
		case "TAGNAME":
			return driver.findElements(By.tagName(locator));
		default:
			throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
		}
	}

	@Override
	public boolean isDisplayed(WebElement e) {
		return e.isDisplayed();
	}

	@Override
	public boolean isEnabled(WebElement e) {
		return e.isEnabled();
	}

	@Override
	public boolean isSelected(WebElement e) {
		return e.isSelected();
	}

	@Override
	public void click(WebElement e) {
		e.click();

	}

	@Override
	public void type(WebElement e, String textToType) {
		e.sendKeys(textToType);

	}

	@Override
	public void closeCurrentTabWindow() {
		driver.close();

	}

	@Override
	public void closeBrowser() {
		driver.quit();

	}

	@Override
	public String fetchTitle() {
		return driver.getTitle();
	}

	@Override
	public void implementImplicitWait(int waitInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSeconds));	
	}

	@Override
	public String getVisibleText(WebElement e) {
		// TODO Auto-generated method stub
		return e.getText();
	}

}
