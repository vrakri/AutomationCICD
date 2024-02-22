package rahulshettyacademy.data;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class DataReader {

	
	public getJsonDataToMap()
	
	{  //read json to string
		String jsonContent =  FileUtils.readFileToString( new File (System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"));
	
		//String to HashMap
		
		
	}
}
