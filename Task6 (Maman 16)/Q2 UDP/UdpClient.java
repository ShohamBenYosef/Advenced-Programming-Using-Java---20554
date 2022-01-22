import java.io.IOException;
import java.net.*;

public class UdpClient {

    public static void main(String[] args) {
        String host = "localhost";
        if (args.length > 0) host = args[0];
        DatagramSocket socket = null;
        // get a datagram socket on any avy available port
        try{
            socket = new DatagramSocket();
            // send request
            byte[] buf = new byte[1024];
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4446);
            socket.send(packet);

            // get response:
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            // display response:
            buf = packet.getData();
            int len = packet.getLength();
            String received = (new String(buf)).substring(0, len);
            System.out.println("Today date: " + received);
            socket.close();
        } catch (SocketException e){
            e.printStackTrace();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



    }


}
