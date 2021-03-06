import java.io.*;
import java.net.*;
 
public class TcpClient {
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
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
	System.out.println("Your turn...please move...."); 
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        ) {
            String input;
	    String inputLine;
	    int other_row;
	    int other_column;
	    int this_row;
	    int this_column;

            while ((input = stdIn.readLine()) != null) {
		System.out.println("Board after your move:");
		this_row=(int)input.charAt(0)-48;
	        this_column=(int)input.charAt(2)-48;
		arr[this_row][this_column]=1;
		display(arr);
		System.out.println("Player 2's turn. Please wait.....");
                out.println(input);
		inputLine=in.readLine();
		other_row=(int)inputLine.charAt(0)-48;
	        other_column=(int)inputLine.charAt(2)-48;
		arr[other_row][other_column]=2;
		System.out.println("Player 2's move:");
		display(arr);
		System.out.println("Your turn...please move....");
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
