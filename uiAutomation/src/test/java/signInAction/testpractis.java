package signInAction;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class testpractis {
	
	Properties property ;
	
	public void loadData() throws IOException{
		
		property = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\configTest.properties");
		FileReader f = new FileReader(file);
		property.load(f);
		
		File file1 = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
		FileReader f1 = new FileReader(file1);
		property.load(f1);
		
	}
	
	public String getObject(String data) throws IOException{
		loadData();
		return property.getProperty(data);
	}
	
	@Test
	public void getProperties() throws IOException{
		System.out.println(getObject("Name"));
		System.out.println(getObject("Place"));
		System.out.println(getObject("url"));
		System.out.println(getObject("browser"));
	}
	
}
