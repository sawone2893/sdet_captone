package sdet_capstone.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	private static Properties props;

	public static void init() {
		String env = System.getProperty("env"); 
		// default env
		if(env==null) {
			env="qa";
		}
		String filePath = System.getProperty("user.dir") + "\\resources\\envConfig\\" + "config-" + env + ".properties";
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load: " + filePath, e);
		}

	}

	public static String get(String key) {
		if (props == null) {
			init();
		}
		return props.getProperty(key);
	}

	public static String getOrDefault(String key, String def) {
		return props.getProperty(key, def);
	}

	public static boolean getBool(String key) {
		return Boolean.parseBoolean(props.getProperty(key, "false"));
	}
}
