
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class UdpServer {

    private DatagramSocket socket = null;
    private boolean moreClient = true;

    public  UdpServer(){
        try {
            socket = new DatagramSocket(4446);
            System.out.println("Server Ready");

        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start(){
        DatagramPacket packet;
        while (moreClient){
            try {
                byte[] buf = new byte[1024];

                // receive request:
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);


                /*
                String msg = new String(packet.getData()).substring(0, packet.length());
                msg = msg.getUpperCase();
                */

                // prepare response:
                String dString = new Date().toString();
                buf = dString.getBytes();

                // send the response to "address" and "port":
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            }
            catch (IOException exception){
                exception.printStackTrace();
                moreClient = false;
            }
        }
        socket.close();
    }



    public static void main(String[] args){
        UdpServer server = new UdpServer();
        server.start();
    }
}