package com.saslesForce.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	
	static String projDIr= System.getProperty("user.dir");
	static String jsonPath = projDIr +"\\src\\main\\java\\com\\SalesForce\\Data\\UserTestData.json";
	
	
	
	public static List<HashMap<String, String>> callJsonReader() throws IOException {
		  System.out.println("Json File PAth: "+ jsonPath);
		//Read Json to String
		String JsonStringFormat = FileUtils.readFileToString(new File(jsonPath),  StandardCharsets.UTF_8);
		
		//Convert String to Map - Jackson DatBind
		
		ObjectMapper mapper = new ObjectMapper();
		//mapper.readValue(JsonStringFormat, null);
		List<HashMap<String, String>> data = mapper.readValue(JsonStringFormat, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
