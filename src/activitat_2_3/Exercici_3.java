package activitat_2_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Exercici_3 {

	private static String fileName = "activitat_2_3_data.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String folderPath = scannerToString("Enter the full path of the file to read. If not existing a new one is created (default name: "+fileName+"): ");
		String[] elements = new String[]{String.valueOf(true),"More content UTF-8", "Castañas and té","\n"};
		File file = new File(folderPath);
		appendContentIntoFile(file, elements);
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
	

	//enter content inside a File
	public static void enterContentIntoFile(File file, String[] content) 
	{
		try {
			DataOutputStream outData = new DataOutputStream(new FileOutputStream(file));
			//DataOutputStream outData = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath())));

			for(int i = 0; i < content.length; i++)
			{
				outData.writeUTF(content[i]);
			}
			outData.close();
			outData.flush();

			System.out.println("Data saved");	
		}
		catch(Exception e)
		{
			System.out.println("Data not saved");
		}
	}	
	

	//append content into a file
	public static void appendContentIntoFile(File file, String[] content)
	{
		//check if entered file exists and it is a file
		if(file.exists() && file.isFile()) {
		
			try {	
			
				DataOutputStream appendData = new DataOutputStream(new FileOutputStream(file, true));
				
				for(int i = 0; i < content.length; i++)
				{
					appendData.writeUTF(content[i]);
				}
				appendData.close();
				System.out.println("Data appended");
				readContentFromFile(file);
			}
			catch(Exception e)
			{
				System.out.println("Data not appended");
			}
		}
		else 
		{
			File newFile = new File(file.getAbsolutePath()+"/"+fileName);
			//create a new file in case the requested one does not exist
			enterContentIntoFile(newFile, content);
			readContentFromFile(newFile);
		}
	}
	
	//read content from file
	public static void readContentFromFile(File file)
	{
		if(file.exists())
		{
			try {
			
				DataInputStream inData = new DataInputStream (new FileInputStream(file));
				//DataInputStream inData = new DataInputStream (new BufferedInputStream(new FileInputStream(file.getAbsolutePath())));
				
				//available checks if there is more elements inside the file
				while(inData.available()>0)
				{
					System.out.println(inData.readUTF());
				}
				inData.close();
			}
			catch(Exception e)
			{
				System.out.println("Data not read");
			}
		}
		else
		{
			System.out.println("File not found");
		}			
	}	
}
