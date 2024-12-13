package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility 
{
	
	public String getdatafromPropertiesFile(String key) throws Throwable
	{
		//FileInputStream fis =new FileInputStream(".\\configAppData\\commondata1.properties");
		FileInputStream fis =new FileInputStream(Ipathconstant.filepath);
		Properties pro=new Properties();
		pro.load(fis);
		
		String data=pro.getProperty(key);
		return data;
	}

}
