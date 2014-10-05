package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Properties;

import com.example.framework.ApplicationManager;

public class Sample {

	public static void main(String[] args) throws FileAlreadyExistsException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		ApplicationManager app = new ApplicationManager(properties);
		System.out.println(app.getHibernateHelper().listGroups());
	}

}
