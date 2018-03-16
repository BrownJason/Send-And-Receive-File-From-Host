package cooksys.sender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HostedServer {
	/**
	 * Listen for incoming connectiosn and read the incoming data
	 * as a file which is stored locally on the machine
	 */
	
	public static void main(String[] args) {
		try (ServerSocket send = new ServerSocket(10101)){
			File file = new File("C:\\Users\\ftd-01\\test1.txt");
			
			System.out.println("Waiting for a file from : " + send);
			Socket socket = send.accept();
			
//			DataInputStream readFile = new DataInputStream(socket.getInputStream());
//			String someString = readFile.readUTF();
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String newLine;
			DataOutputStream doss = new DataOutputStream(new FileOutputStream(file));
			String nextLine = System.getProperty("line.separator");
			while((newLine = buffRead.readLine()) != null) {
				doss.writeBytes(newLine);
				doss.writeBytes(nextLine);
			}
			
			System.out.println("Received from : " + socket);
//			String message = stringBuff.toString();
//			doss.writeBytes(message + '\n');
			
//			DataOutputStream doss = new DataOutputStream(new FileOutputStream(file));
//			doss.writeUTF(stringBuff.toString());

			System.out.println("Message Received");
			doss.close();
			socket.close();
			send.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
}
