package activitat_2_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Exercici_2 {

	public static String fileName = "activitat_2_2_data.txt";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String filePath = scannerToString("Enter the full folder's path where new file is created (file's name: "+fileName+")");
		File outFile = new File(filePath);
		
		String[] elements = new String[]{String.valueOf(369),"Español and Català  (ä,è,i,ó,ü)","This is code using UTF-8"};
		
		enterContentIntoFile(outFile, elements);
		readContentFromFile(outFile);
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
