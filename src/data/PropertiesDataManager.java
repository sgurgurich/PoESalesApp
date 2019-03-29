package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import utils.FileUtils;

public class PropertiesDataManager {
	
	private String configDirectoryName = "PoESalesApp/";
	private String appDataDirectoryName = "AppData/Local/";
	private String configFileName = "appProps.txt";
	private String pathToConfigFile = FileUtils.getUserHomeDirectoryPath()
									+ appDataDirectoryName 
									+ configDirectoryName 
									+ configFileName;
	
	private Properties props = null;
	private File propFile = null;
	
	public PropertiesDataManager() {
		
		propFile = new File(pathToConfigFile);
		if (!propFile.exists()) {
			if (propFile.canWrite()) {
				try {
					propFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("Cannot create config file.");
			}			
		}
		
		if (propFile.exists()) {
			props = new Properties();
			
			FileInputStream in;
			try {
				in = new FileInputStream(propFile);
				props.load(in);
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}		
	
	public String readProperty(String key) {
		
		if (props != null) {
			return props.getProperty(key);
		} else {
			System.err.println("Unable to set read property. Property file not loaded yet.");
		}
		
		return null;
	}
	
	public void setProperty(String key, String value) {
		
		if (props != null) {
			props.setProperty(key, value);
		} else {
			System.err.println("Unable to set property. Property file not loaded yet.");
		}		
	}
	
}
