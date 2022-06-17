package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil {
	
	Properties pro;	
	public ConfigUtil()
	{
		File src = new File(".//config//config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
	public String getApplicationUrl()
	{
		return pro.getProperty("app.url");
	}
	
	public String getUserName()
	{
		return pro.getProperty("user.name");
	}
	
	public String getPassword()
	{
		return pro.getProperty("user.password");
	}
	
	public String getChromePath()
	{
		return pro.getProperty("driver.chromepath");
	}
	
	public String getEdgePath()
	{
		return pro.getProperty("driver.edgepath");
	}
	
	public String getGeckoPath()
	{
		return pro.getProperty("driver.geckopath");
	}
	
	public String getLog4jPath()
	{
		return pro.getProperty("log4j.path");
	}

}
