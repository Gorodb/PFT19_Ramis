package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.example.framework.ApplicationManager;

public class BaseClass {
	
	protected static String groupSelectedData;
	
	protected ApplicationManager app;
	
	@BeforeTest
	public void setUp() throws Exception {
	    app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

}
