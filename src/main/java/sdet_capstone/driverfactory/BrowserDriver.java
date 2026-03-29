package sdet_capstone.driverfactory;

import org.openqa.selenium.WebDriver;

public interface BrowserDriver {
	
	public WebDriver launchBrowser(boolean isHeadless);

}
