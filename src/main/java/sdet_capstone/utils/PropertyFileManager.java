package sdet_capstone.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileManager {
	static Properties prop = null;

	public static String getPropertyValue(String keyName) {
		String filePath = System.getProperty("user.dir") + "/src/main/java/sdet_capstone/config/config.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			new Properties();
			prop.load(fis);
		} catch (Exception e) {

		}
		return prop.getProperty(keyName);
	}

}
