import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Scanner;

import java.lang.Throwable;

public class SocketServerTest {

	public static void main(String[] args) throws Throwable{
		
		ServerSocket server = new ServerSocket(9777);
		Socket client = server.accept();

		DataInputStream is = new DataInputStream(client.getInputStream());
		DataOutputStream os = new DataOutputStream(client.getOutputStream());
		
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("Starting");
			String fromClient = is.readUTF();
			System.out.println("From Client :: " + fromClient);
        	String msg = in.nextLine();
        	os.writeUTF(msg);
        	os.flush();
        	System.out.println("closing");
		}

		/*ServerSocket ss=new ServerSocket(3333);  
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){  
		str=din.readUTF();  
		System.out.println("client says: "+str);  
		str2=br.readLine();  
		dout.writeUTF(str2);  
		dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();*/
	}
}

