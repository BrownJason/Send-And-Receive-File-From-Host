package cooksys.sender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class SendFile {
	public static void main(String[] args) {
		try {
			Socket reciever = new Socket("localhost", 10101);
			
			File text = new File("C:\\Users\\ftd-01\\test.txt");
			FileReader fileRead = new FileReader(text);
			BufferedReader inputFromFile = new BufferedReader(fileRead);
//			System.out.println(inputFromFile.readLine());
			
//			String firstLine = inputFromFile.readLine();
//			System.out.println(firstLine);			
			
			String newLine;
			DataOutputStream boss = new DataOutputStream(reciever.getOutputStream());
			String nextLine = System.getProperty("line.separator");
			
			while((newLine = inputFromFile.readLine()) != null) {
//				string.append(newLine);
//				string.append('\n');
				boss.writeBytes(newLine);
				boss.writeBytes(nextLine);
			}
			
			
			inputFromFile.close();
			reciever.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
