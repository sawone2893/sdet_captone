package sdet_capstone.driverfactory;

public class BrowserDriverFactory {

	public static BrowserDriver getBrowserDriver(String browserType) {
		switch (browserType.toUpperCase()) {
		case "CHROME":
			return new ChromeBrowserManager();

		case "FIREFOX":
			return new FireFoxBrowserManager();

		case "EDGE":
			return new EdgeBrowserManager();
		default:
			throw new IllegalArgumentException("Unsupported browser type: " + browserType);
		}

	}

}
