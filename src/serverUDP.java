/**@author Feisal Salim
 * SID:824317549
 * */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;



public class serverUDP {
	public static FileOutputStream stream;
	public static String modFile;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		public static void main (String [] args) throws IOException
		   {
		      System.out.println ("Server starting ...\n");

		      // Create a datagram socket bound to port 40050. Datagram
		      // packets sent from client programs arrive at this port.
		      
			DatagramSocket s = new DatagramSocket (40050);	
			
			
		         // Receive a datagram packet from the client program.
		    int i=0;	  
			    
		      while (true)
		      {
		    	 byte [] filename = new byte [100];
		    	 DatagramPacket dgp = new DatagramPacket (filename, filename.length);
		    	 
		    	 	s.receive(dgp);
		    	  
		    	  
                      String x=new String(filename).trim();
                      
                          if(x.endsWith(".txt")){                                 
                     	 	modFile=x.concat(".bak");                       	 	     	 	                        	 	
                     	 	stream = new FileOutputStream(modFile,false);
                          }
                          
                          	while(true){
	                    		byte [] filedata = new byte [100];
	                    		DatagramPacket d = new DatagramPacket (filedata, filedata.length);
	                    		s.receive(d);   		    	  
	                    		x=new String(filedata);
	                    		 
	                    		// System.out.println(" packet= "+(i++)+" "+x );
	                    		 if(x.isEmpty()==true){
	                        	  	break;
		                        	 
		                        	 
		                         }else if(!x.endsWith(".txt")){                                       
		                     	 	stream.write(x.getBytes());
		                         }                                     
                          	}
                    stream.close();
    
			    	  	
			  }
		    
		   }
		
}
