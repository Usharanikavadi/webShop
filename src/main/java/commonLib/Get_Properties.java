package commonLib;

import java.io.FileInputStream;
import java.util.Properties;

public class Get_Properties {
	
	Properties prop = new Properties();	

	public Get_Properties(String filepath) throws Exception {
		
		prop.load(new FileInputStream(filepath));
	}
	
	public String getProperty(String key) {
		 return prop.getProperty(key);		
	}
}
