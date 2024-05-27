import java.io.IOException;
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
            }
        }
    }

    private static String allMethodDependingOnOperatorSign(String msg) {
        String[] args = new String[2];
        if (msg.contains("+")) {
            args = msg.split("\\+");
            System.out.println(args[0] + " | " + args[1]);

            return addition(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {

            return "NOLL";
        }

    }


    static String addition(int arg1, int arg2) {
        int result = arg1 + arg2;
        return String.valueOf(result);
    }

    static String subtraction(int arg1, int arg2) {
        String result = "";


        return result;
    }

    static String division(int arg1, int arg2) {
        String result = "";


        return result;
    }

    static String multiplication(int arg1, int arg2) {
        String result = "";


        return result;
    }


}