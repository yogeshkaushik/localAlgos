import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

import java.lang.Throwable;

public class SocketClientTest {

	public static void main(String[] args) throws Throwable{
		Socket myself = new Socket("localhost", 9777);
		
		DataInputStream is = new DataInputStream(myself.getInputStream());

		DataOutputStream os = new DataOutputStream(myself.getOutputStream());

		Scanner in = new Scanner(System.in);
		while(true) {
	        	String msg = in.nextLine();
	        	os.writeUTF(msg+"");
	        	os.flush();
	        	System.out.println(is.readUTF());
		}		

		/*Socket s=new Socket("localhost",3333);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){  
		str=br.readLine();  
		dout.writeUTF(str);  
		dout.flush();  
		str2=din.readUTF();  
		System.out.println("Server says: "+str2);  
		} 
		  
		dout.close();  
		s.close();*/ 
	}
}

