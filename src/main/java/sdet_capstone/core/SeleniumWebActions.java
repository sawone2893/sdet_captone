package sdet_capstone.core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWebActions implements WebActions {

	private WebDriver driver = null;

	public SeleniumWebActions(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void launchUrl(String url) {
		this.driver.get(url);
	}

	@Override
	public void maximizeBrowser() {
		this.driver.manage().window().maximize();
	}

	@Override
	public WebElement getElement(String locatorType, String locator) {
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			return this.driver.findElement(By.xpath(locator));
		case "CSS":
			return this.driver.findElement(By.cssSelector(locator));
		case "ID":
			return this.driver.findElement(By.id(locator));
		case "CLASSNAME":
			return this.driver.findElement(By.className(locator));
		case "NAME":
			return this.driver.findElement(By.name(locator));
		case "LINKTEXT":
			return this.driver.findElement(By.linkText(locator));
		case "PARTIALLINKTEXT":
			return this.driver.findElement(By.partialLinkText(locator));
		case "TAGNAME":
			return this.driver.findElement(By.tagName(locator));
		default:
			throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
		}
	}

	@Override
	public List<WebElement> getElements(String locatorType, String locator) {
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			return this.driver.findElements(By.xpath(locator));
		case "CSS":
			return this.driver.findElements(By.cssSelector(locator));
		case "ID":
			return this.driver.findElements(By.id(locator));
		case "CLASSNAME":
			return this.driver.findElements(By.className(locator));
		case "NAME":
			return this.driver.findElements(By.name(locator));
		case "LINKTEXT":
			return this.driver.findElements(By.linkText(locator));
		case "PARTIALLINKTEXT":
			return this.driver.findElements(By.partialLinkText(locator));
		case "TAGNAME":
			return this.driver.findElements(By.tagName(locator));
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
	public String fetchTitle() {
		return this.driver.getTitle();
	}

	@Override
	public void implementImplicitWait(int waitInSeconds) {
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSeconds));
	}

	@Override
	public String getVisibleText(WebElement e) {
		// TODO Auto-generated method stub
		return e.getText();
	}

}
