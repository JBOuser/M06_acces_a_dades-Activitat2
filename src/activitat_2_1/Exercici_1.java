package activitat_2_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Exercici_1 {

	public static String fileName = "activitat_2_1_bytes.txt";

	//It is necessary adding an Exception in order to manage the Exception 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String filePath = scannerToString("Enter the full folder's path where new file is created (file's name: "+fileName+")");
		File outFile = new File(filePath+"/"+fileName);
		createFileWithContent(outFile);
	}
	
	//Scan content from input Console and return it as String
	public static String scannerToString(String text)
	{
		System.out.println(text);
		Scanner sc = new Scanner(System.in);
		String inputContent = sc.next();
		sc.close();
		return inputContent;
	}
	
	public static void createFileWithContent(File file) throws Exception 
	{
		
		if (file.exists())
		{
			//open memory in order to add content, add it and close this onto used memory, which means the content is
			//saved in the HDD
			DataOutputStream newContent = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			newContent.writeBoolean(true);
			newContent.writeInt(100001);
			newContent.writeUTF("Set of characters");
			newContent.close();
			
			//File is created
			//File file = new File(path);
			//FileInputStream inputStream = new FileInputStream(file);
			//DataInputStream readContent = new DataInputStream(new BufferedInputStream (inputStream));
			DataInputStream readContent = new DataInputStream(new BufferedInputStream (new FileInputStream(file)));
			
			//byte bytes_content[]=path.getBytes();
			
			int readChar = 0;
			while(readChar!=-1)
			{
				readChar = readContent.read();		
				System.out.println(readChar+" -> "+(char)readChar);
				//System.out.println((char)readChar+" : "+readChar);
			}
			readContent.close();			
		}
		
		else
		{
			System.out.println("Folder not found ("+file.getAbsolutePath()+")");
		}
	}
}
