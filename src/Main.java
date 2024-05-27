import javax.swing.*;
import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ServerSocket server = null;
        Socket client;

        // Default port number we are going to use
        int portNumber = 50000;
        if (args.length >= 1) {
            portNumber = Integer.parseInt(args[0]);
        }

        // Create server side socket
        try {
            server = new ServerSocket(portNumber);
        } catch(IOException ie) {
            System.out.println("Canot open socket." + ie);
            System.exit(1);
        }
        System.out.println("ServerSocket is created " + server);

        // Wait for the data from the client and reply
        while(true) {
            try {
                // Listens for a connection to be made to
                // This socket and accepts it. The methods block until
                // a connection is made
                System.out.println("Waiting for connect request...");
                client = server.accept();

                System.out.println("Connect request is accepted...");
                String clientHost = client.getInetAddress().getHostName();
                int clientPort = client.getPort();
                System.out.println("Client host = " + clientHost + " Client port = " + clientPort);

                // Read data from the client
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                String msgFromClient = br.readLine();
                System.out.println("Message received from client = " + msgFromClient);

                // Send response to client
                if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("Bye")) {



                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);
                    //String ansMsg = "Hello, " + msgFromClient;
                    String ansMsg = callMethodDependingOnOperatorSign(msgFromClient);
                    pw.println(ansMsg);
                }

                // Close the sockets
                if (msgFromClient != null && msgFromClient.equalsIgnoreCase("Bye")) {
                    server.close();
                    client.close();
                    break;
                }
            } catch (IOException ie) {
                System.out.println("Could not connect to server" + ie);
            }
        }
    }

    private static String callMethodDependingOnOperatorSign(String msg) {
        String[] args = new String[2];
        if (msg.contains("+")) {
            args = msg.split("\\+");
            return addition(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else if (msg.contains("-")) {
            args = msg.split("-");
            return subtraction(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else if (msg.contains("/")) {
            args = msg.split("/");
            return division(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }else if (msg.contains("*")) {
            args = msg.split("\\*");
            return multiplication(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            return "You did not enter a math problem";
        }

    }


    static String addition(int arg1, int arg2) {
        int result = arg1 + arg2;
        return String.valueOf(result);
    }

    static String subtraction(int arg1, int arg2) {
        int result = arg1 - arg2;
        return String.valueOf(result);
    }

    static String division(int arg1, int arg2) {
        int result = arg1 / arg2;
        return String.valueOf(result);
    }

    static String multiplication(int arg1, int arg2) {
        int result = arg1 * arg2;
        return String.valueOf(result);
    }


}