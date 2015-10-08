import java.net.*;
import java.io.*;
 
public class TcpServer {
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
            ServerSocket serverSocket =
                new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();    
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                  
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));

        ) {
            String inputLine;
	    int other_row;
	    int other_column;
	    int this_row;
	    int this_column;
            while ((inputLine = in.readLine()) != null) {
		other_row=(int)inputLine.charAt(0)-48;
	        other_column=(int)inputLine.charAt(2)-48;
		arr[other_row][other_column]=1;
		System.out.println("Player 1's move:");
		display(arr);
		System.out.println("Your turn...please move....");
		String userInput=stdIn.readLine();
		this_row=(int)userInput.charAt(0)-48;
	        this_column=(int)userInput.charAt(2)-48;
		arr[this_row][this_column]=2;
		System.out.println("Board after your move:");
		display(arr);
		System.out.println("Player 1's turn. Please wait.....");
		out.println(userInput);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
