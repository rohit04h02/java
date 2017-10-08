import java.io.*;
import java.net.*;

changes made in local

public class Client 
	{
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	Client()
	{
    try{
	s=new Socket("localhost",10); //enter your ipv4 address
	System.out.println("Client Started"+s);
	System.out.println("Client Connected");
	in=new DataInputStream(s.getInputStream());
	out=new DataOutputStream(s.getOutputStream());
	clientchat();
	}
	catch(Exception e)
	{
		System.out.println(e);		
	}
	}
	public void clientchat()throws IOException
	{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
   	String st;	
    do
	{
	st=br.readLine();
	out.writeUTF(st);
    System.out.println("Server message :"+in.readUTF());
	}while(!st.equals("stop"));	
	}
	public static void main(String s1[])
	{
		new Client();
	}
	}
	
