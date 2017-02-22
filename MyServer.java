import java.io.*;
import java.net.*;

public class MyServer 
	{
	Socket s;
	ServerSocket ss;
	DataInputStream in;
	DataOutputStream out;
	MyServer()
	{
    try{
	ss=new ServerSocket(10);
	System.out.println("Server Started  "+ss);
	s=ss.accept();
	System.out.println("Client Connected"+s);
	in=new DataInputStream(s.getInputStream());
	out=new DataOutputStream(s.getOutputStream());
	serverchat();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public void serverchat()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String st;
		do{	
		st=in.readUTF();
		System.out.println("Client Message :"+st);
		st=br.readLine();
	    out.writeUTF(st);
		out.flush();
		}while(!st.equals("stop"));	
	}
public static void main(String a[])
{
 new MyServer();
}
	}
