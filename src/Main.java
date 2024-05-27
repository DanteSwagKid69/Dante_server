import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {
    public static void main(String[] args) throws Exception {


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