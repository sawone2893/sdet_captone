package sdet_capstone.driverfactory;

import java.util.List;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxBrowserManager implements BrowserDriver{
	
	private WebDriver driver=null;

	@Override
	public WebDriver launchBrowser(boolean isHeadless) {
		FirefoxOptions options= new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--incognito");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		if(isHeadless)options.addArguments("--headless=new");

		driver= new FirefoxDriver(options);
		return driver;
	}

}
