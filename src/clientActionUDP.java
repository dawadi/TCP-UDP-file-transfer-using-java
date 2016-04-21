import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class clientActionUDP {
	
	/**
	 * This constructor is a UDP based file transfer to a server
	 * @param IP address , Server port number,The file you wish to transfer as a File.
	 **/
	
	public void clientRequest(String ip ,String port,File file) throws IOException{
	     
		 
			
	       DatagramSocket s = null;
			try{
				s = new DatagramSocket ();
				
				InetAddress ia = InetAddress.getByName (ip);
				int Port=Integer.parseInt(port);
				
				byte[]filename =file.getName().getBytes();
				FileInputStream  f = new FileInputStream(file);
				
				byte[] buffer = new byte[100];
				
				DatagramPacket nam = new DatagramPacket (filename,filename.length,ia,Port);
				s.send (nam);
				
				while(f.read(buffer)!=-1){				        
					DatagramPacket dgp = new DatagramPacket (buffer,buffer.length,ia,Port);
					s.send(dgp);
				}
				 f.close();
				 
			}catch (IOException e)
		      {
		          System.out.println (e.toString ());
		      }
		      finally
		      {
		          if (s != null)
		              s.close ();
		      }

		
	}

}
