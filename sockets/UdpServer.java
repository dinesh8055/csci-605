import java.net.*;
import java.io.*;
 
public class UdpServer {
    static int[][] arr={{0,0,0},{0,0,0},{0,0,0}};
    static void display(int[][] arr){
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		System.out.print(arr[i][j]+" ");
	    }
	    System.out.println();
	}
	System.out.println();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
      
        int portNumber = Integer.parseInt(args[0]);
	System.out.println("Player 1's turn. Please wait.....");   
        try (
            DatagramSocket serverSocket =
                new DatagramSocket(Integer.parseInt(args[0]));                
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        ) {
            String inputLine;
	    String userInput;
	    int other_row;
	    int other_column;
	    int this_row;
	    int this_column;
            byte[] buf = new byte[256];
	    DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while (true) {
		serverSocket.receive(packet);
		inputLine=new String(packet.getData());
		other_row=(int)inputLine.charAt(0)-48;
	        other_column=(int)inputLine.charAt(2)-48;
		arr[other_row][other_column]=1;
		System.out.println("Player 1's move:");
		display(arr);
		System.out.println("Your turn...please move....");
		userInput=stdIn.readLine();
		buf=userInput.getBytes();
		this_row=(int)userInput.charAt(0)-48;
	        this_column=(int)userInput.charAt(2)-48;
		arr[this_row][this_column]=2;
		System.out.println("Board after your move:");
		display(arr);
		System.out.println("Player 1's turn. Please wait.....");
		InetAddress address = packet.getAddress();
                int port = packet.getPort();
		DatagramPacket to_packet = new DatagramPacket(buf, buf.length,address,port);
		serverSocket.send(to_packet);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
