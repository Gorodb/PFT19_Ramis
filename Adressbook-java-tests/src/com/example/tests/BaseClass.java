package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.framework.ApplicationManager;

public class BaseClass {
	protected Logger log = Logger.getLogger("TEST");
	protected ApplicationManager app;
	
	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getenv("configFile");
		}
		if (configFile == null) {
			configFile = System.getProperty("configFile");
		}
		if (configFile == null) {
			configFile = System.getProperty("application.properties");
		}
		Properties props = new Properties();
		props.load(new FileReader(new File(configFile)));
	    log.info("setUp start.");
		app = new ApplicationManager().getInstance();
	    app.setProperties(props);
	    log.info("setUp end.");
	  }

	@AfterTest
	public void tearDown() throws Exception {
		log.info("TearDown start");
		ApplicationManager.getInstance().stop();
		log.info("TearDown end");
	  }
	
}
