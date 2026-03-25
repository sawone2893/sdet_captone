package sdet_capstone.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileManager {
	static Properties prop = null;

	public static String getPropertyValue(String keyName) {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\sdet_capstone\\config\\config.properties";
		try {
			File f= new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load config.properties file located at "+filePath);
			e.printStackTrace();
		}
		return prop.getProperty(keyName);
	}

}
