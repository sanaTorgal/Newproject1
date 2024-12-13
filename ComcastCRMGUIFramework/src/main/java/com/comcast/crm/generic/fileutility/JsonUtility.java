package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.json.Json;

public class JsonUtility
{
	public String getDataFromJsonFile(String key) throws Throwable
	{
		FileReader fileR=new FileReader(".\\configAppData\\appdata.json");
		JSONParser parser=new JSONParser();
				Object obj = parser.parse(fileR);
				JSONObject map=(JSONObject)obj;
				String data=(String)map.get(key);
				return data;
		
	}

}
