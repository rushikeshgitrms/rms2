package com.Test.ConfigFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	String PropLocation = System.getProperty("user.dir") + "/Configuations/instance&credentials.properties";

	public final String PropertyFilePath = PropLocation;
	public static Properties properties;

	public ConfigFileReader()  {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(PropertyFilePath));
		} catch (FileNotFoundException e) {
			System.out.println("Reader not loading");
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(reader);
		} catch (IOException e) {
			System.out.println("properties not loading");
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("reader not loading");
			e.printStackTrace();
		}
	}

	public String browser() {
		String browser = properties.getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("browser is not specified in the concerned property file");
		}

	}

	public String url() {
		String url = properties.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url is not specified in the concerned property file");
		}

	}

	public String username() {
		String username = properties.getProperty("username");
		if (username != null) {
			return username;
		} else {
			throw new RuntimeException("username is not specified in the concerned property file");
		}

	}

	public String password() {
		String password = properties.getProperty("password");
		if (password != null) {
			return password;
		} else {
			throw new RuntimeException("password is not specified in the concerned property file");
		}

	}
}
