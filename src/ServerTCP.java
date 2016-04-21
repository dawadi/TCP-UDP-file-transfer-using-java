/**
 * @author feisalsalim
 * 
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	 private static String modFile;
	 private static final int BUFFERSIZE = 32; // Size of the receive buffer
	 private static FileOutputStream stream;
	 private static File f;
     public static void main ( String [ ] args ) throws IOException {
     // main application begins here
        
          int serverListenPort ;  // define the integer port number
          BufferedReader inValue = new BufferedReader(new InputStreamReader(System.in));
          int receivedMessageSize=0; // size of the received message from Client
          byte [ ] byteBuffer = new byte [BUFFERSIZE]; // create byte buffer
          byte [] msg = new byte[20];

          System.out.println("\n Enter the port number to listen to:\t");
          serverListenPort = Integer.parseInt(inValue.readLine() );


      

             ServerSocket serverSocket = new ServerSocket(serverListenPort);

             for ( ; ; ) { 
                Socket clientSock  = serverSocket.accept();  // Get the client connection
        
                  // Now that we have the Client connection accepted, 
                  // Display client socket information

                  System.out.println("\n....Handling Client at:....");

           System.out.println( clientSock.getInetAddress().getHostAddress() + "\n  on port number:\t" + clientSock.getPort() );
         
            // Create an instance of InputStream from instance of Client Socket

                 InputStream in = clientSock.getInputStream();

           // Create an instance of OutputStream from instance of Client Socket

                 OutputStream out = clientSock.getOutputStream();


           // Keep on receiving the data from the Client until end of 
           // the data (refer by -1) 

         
                 while (( receivedMessageSize = in.read(byteBuffer)) != -1){
                         out.write(byteBuffer, 0, receivedMessageSize);
                         String x=new String(byteBuffer).trim();
                        
	                         if(x.endsWith(".txt")){                                       
	                        	 	modFile=x.concat(".bak");                       	 	     	 	                        	 	
	                        	 	stream = new FileOutputStream(modFile,false);
	                          }
	                         if(x.isEmpty()==true){
	                        	 stream.close();
	                        	 
	                         }else if(!x.endsWith(".txt")){                                       
	                     	 	stream.write(byteBuffer);
	                         } 
                         }
                       
                         
                         // FileOutputStream file = new FileOutputStream();
                 
                 // as the while loop ends (terminated by -1)

                 // close this client's socket
                  msg="bak file created".getBytes();
                  out.write(msg);
                  clientSock.close(); // end of this client's echoed message


             } // end of the for loop

                /******* this part can only be reached with Ctrl C ******/

     } // main application ends here

}
