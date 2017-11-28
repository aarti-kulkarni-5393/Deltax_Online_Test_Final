package DeltaxRegistration.Delatx_registartiongForm.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public  Properties property;
	
	
	public  void loadData() throws IOException
	{
		property = new  Properties();
		File config = new File(System.getProperty("user.dir")+"\\src\\main\\java\\DeltaxRegistration\\Delatx_registartiongForm\\config\\Selenium_Configuration.properties");
//		System.out.println(config.getPath());
		FileInputStream config_reader = new FileInputStream(config);
//		FileReader config_reader = new FileReader(config);
		property.load(config_reader);
	}
	
	
	public String getData(String key) throws Exception
	{
		loadData();
		String data = property.getProperty(key);
	
		return data;
	}
	

	
	

}
