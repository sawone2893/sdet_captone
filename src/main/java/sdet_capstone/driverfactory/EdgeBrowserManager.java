package sdet_capstone.driverfactory;

import java.util.List;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserManager implements BrowserDriver{
	
	private WebDriver driver=null;

	@Override
	public WebDriver launchBrowser(boolean isHeadless) {
		EdgeOptions options= new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--incognito");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
		if(isHeadless)options.addArguments("--headless=new");

		driver= new EdgeDriver(options);
		return driver;
	}


}
