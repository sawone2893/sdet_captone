package sdet_capstone.driverfactory;

import java.util.List;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserManager implements BrowserDriver{
	
	private WebDriver driver=null;

	@Override
	public WebDriver launchBrowser(boolean isHeadless) {
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--incognito");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
		if(isHeadless)options.addArguments("--headless=new");
		
		driver= new ChromeDriver(options);
		return driver;
	}


}
