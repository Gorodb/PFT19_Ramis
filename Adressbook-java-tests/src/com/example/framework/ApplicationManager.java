package com.example.framework;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private Properties props;
	
	public static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}

	public void stop() {
	}

	public void setProperties(Properties props) {
		this.props = props;
	}
	
	public String getProperties(String key) {
		return props.getProperty(key);
	}
	
	public String getProperties(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	
}
