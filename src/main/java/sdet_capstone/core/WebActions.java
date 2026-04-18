package sdet_capstone.core;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface WebActions {
	public void launchUrl(String url);
	public void maximizeBrowser();
	public WebElement getElement(String locatorType,String locator);
	public List<WebElement> getElements(String locatorType,String locator);
	public boolean isDisplayed(WebElement e);
	public boolean isEnabled(WebElement e);
	public boolean isSelected(WebElement e);
	public void click(WebElement e);
	public void type(WebElement e,String textToType);
	public String fetchTitle();
	public void implementImplicitWait(int waitInSeconds);
	public String getVisibleText(WebElement e);
	public String captureScreenshot();
	public void captureScreenshot(String filepath);
	public void captureScreenshot(WebElement e,String filePath);

}
