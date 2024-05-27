import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
public class Main {
    public static void main(String[] args) throws Exception{

        // Default port number we are going to use
        int portNumber = 50000;
        if (args.length >= 1) {
            portNumber = Integer.parseInt(args[0]);
        }

        // Create a MulticastSocket
        MulticastSocket serverMulticastSocket = new MulticastSocket(portNumber);
        System.out.println("MulticastSocket is created at port " + portNumber);

        // Determine the IP adress of host, given the host name
        InetAddress group = InetAddress.getByName("225.4.5.6");

        // getByName- returns IP adress of given host
        serverMulticastSocket.joinGroup(group);
        System.out.println("joinGroup method is called...");

        boolean infinite = true;

        // Continually recevies date and prints them
        while(infinite) {
            byte[] buf= new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);
            String msg = new String(data.getData()).trim();

            // Get the operator sign, for example + or -
            callMethodDependingOnOperatorSign(msg);

            System.out.println("Message received from client = " + msg);
        }
        serverMulticastSocket.close();
    }

    static void callMethodDependingOnOperatorSign(String msg) {
        String[] args = new String[2];
        if (msg.contains("+")) {
            args = msg.split("\\+");
            System.out.println(args[0] + " | " + args[1]);

        }
    }

    static String addition(int arg1, int arg2) {
        String result = "";


        return result;
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