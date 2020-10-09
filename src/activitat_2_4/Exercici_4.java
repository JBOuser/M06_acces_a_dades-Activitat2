/*Link: https://mkyong.com/java/java-properties-file-examples/*/

package activitat_2_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Exercici_4 {

	
	private static String[] propertyKey = new String[]{"db.url","db.user","db.password"};
	private static String[] propertyValue = new String[]{"localhost","userAdmin","passwordAdmin"};
	private static HashMap<String, String> fileProperties = createHashMapFromKeyValue(propertyKey, propertyValue); 
	
	//Main function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File propertyFile = new File(scannerToString("Enter the full path of a property's file (file must exist): "));
		setProperties(propertyFile, fileProperties);
		readProperties(propertyFile, propertyKey);
	}
	
	
	//Scan content from input Console and return it as String
	public static String scannerToString(String text)
	{
		System.out.println(text);
		var sc = new Scanner(System.in);
		String inputContent = sc.next();
		sc.close();
		return inputContent;
	}		

	
	//set properties into a .properties file
	public static void setProperties(File file, HashMap<String, String> keysValues)
	{
		if(file.exists() && file.isFile())
			
			try {
				OutputStream outData = new FileOutputStream(file);
				Properties fileProperties = new Properties();
				
				//get each key and its value (key: .keySet(), value: .values())
				for(Map.Entry<String, String> entry : keysValues.entrySet())
				{
					fileProperties.setProperty(entry.getKey(), entry.getValue());
					//System.out.println(entry.getKey()+":"+entry.getValue());
				}
				
				//second param is for comments (null)
				fileProperties.store(outData, null);
			}
			catch(Exception e)
			{
				System.out.println("Properties not added");
			}
		else
		{
			System.out.println("File not found ("+file.getAbsolutePath()+")");
		}
	}
	
	
	//read set properties from properties file
	public static void readProperties(File file, String[] properties)
	{
		if(file.exists() && file.isFile())
			
			try {
				InputStream inData = new FileInputStream(file);
				Properties fileProperties = new Properties();

				//load data from properties
				fileProperties.load(inData);
				
				for(int i = 0; i < properties.length; i++)
				{
					System.out.println(fileProperties.getProperty(properties[i]));
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Properties not loaded");
			}
		else
		{
			System.out.println("File not found ("+file.getAbsolutePath()+")");
		}		
	}
	
	
	//create a HashMap from list of keys and values
	public static HashMap<String, String> createHashMapFromKeyValue(String[] keys, String[] values)
	{
		HashMap<String, String> valuesKeys = new HashMap<String, String>();

		if(keys.length == values.length)
		{
			
			for(int i = 0; i < keys.length; i++)
			{
				valuesKeys.put(keys[i], values[i]);
			}
			
			return valuesKeys; 
		}
		else
		{
			valuesKeys.put("null","null");
			return valuesKeys;
		}
	}
		
}
