package base;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile_Reader {

	String configFilePath= "E:\\JavaWorkplace\\DataDrivenFW\\Configuration\\config.properties";
	Properties pro;
	
	public PropertyFile_Reader()
	{
		try {
			pro=new Properties();
			FileInputStream file =new FileInputStream(configFilePath);
			pro.load(file);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getUrl()
	{
		String tempUrl=pro.getProperty("url");
		return tempUrl;
	}
	
	public String getChromeKey()
	{
		return pro.getProperty("chromeKey");
	}
	
	public String getChromePath()
	{
		String tempChromePath=pro.getProperty("ChromeDriverPath");
		return tempChromePath;
	}
	
	public String getFirefoxKey()
	{
		String tempFFKey=pro.getProperty("ffKey");
		return tempFFKey;
	}
	
	public String getFirefoxPath()
	{
		String tempFFPath=pro.getProperty("FFDriverPath");
		return tempFFPath;
	}
}
