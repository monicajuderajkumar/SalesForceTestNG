package com.saslesForce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SalesForce.Base.BaseTest;

public class ReadPropertiesFile {
    String propfile ="C:\\Workspace\\com.testNGFrameWork.SalesForce\\Properties\\config.properties";
    FileInputStream fileIO;
    public Logger log;
	
    public String readFromPropFile(String key){
    	
    	 log= LogManager.getLogger(ReadPropertiesFile.class.getClass());
	try {
		fileIO = new FileInputStream(propfile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		 log.error("Unable to read the properties");
		e.printStackTrace();
	}
	
    Properties prop = new Properties();
      
    try {
		prop.load(fileIO);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		 log.error("Unable to load the properties file");
		e.printStackTrace();
	}
    log.info("Property Value : " + key + "Value :" + prop.getProperty(key));
    System.out.println(prop.getProperty(key));
    String value = prop.getProperty(key);
    return value;
	}
	
	}
