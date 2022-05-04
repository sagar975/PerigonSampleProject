package com.perigon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	protected FileInputStream file;
	protected Properties properties;

	public PropertiesReader() throws IOException {
		properties = new Properties();

		file = new FileInputStream(new File(
				"C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\Properties\\EnvironmentVariables.properties"));

		properties.load(file);

	}

	public String getUrl() {

		return properties.getProperty("url");
	}

	public String getUserName() {

		return properties.getProperty(("userName"));

	}

	public String getPassword() {

		return properties.getProperty("passWord");

	}

}
