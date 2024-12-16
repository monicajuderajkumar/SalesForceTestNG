package com.saslesForce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class ReadPropertiesFile {
    String propfile ="C:\\Workspace\\com.testNGFrameWork.SalesForce\\Properties\\config.properties";
    FileInputStream fileIO;
	
    public String readFromPropFile(String key){
	try {
		fileIO = new FileInputStream(propfile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    Properties prop = new Properties();
      
    try {
		prop.load(fileIO);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(prop.getProperty(key));
    String value = prop.getProperty(key);
    return value;
	}
	
	}
