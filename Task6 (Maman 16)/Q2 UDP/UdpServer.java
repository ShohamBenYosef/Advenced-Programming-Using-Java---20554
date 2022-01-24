import java.util.Scanner;
import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UdpServer extends Thread {

    private DatagramSocket serverSocket = null;
    private boolean moreClient = true;

    public  UdpServer(){
            try {
                serverSocket = new DatagramSocket(9876);
                System.out.println("Server Ready");

            } catch (SocketException e) {
                e.printStackTrace();
            }

    }


    @Override
    public void run() {
        super.run();

        while(moreClient){
                sendAndReceive(serverSocket);
            }
    }


    public synchronized void sendAndReceive(DatagramSocket socket){
        try {
            // receive
            byte[] receive = new byte[1024];
            DatagramPacket packet = new DatagramPacket(receive, receive.length);
            serverSocket.receive(packet);

            // process
            String msg = new String(packet.getData()).substring(0,packet.getLength());
            msg = openFileAndGetWeather(msg);

            // send
            int p = packet.getPort();
            InetAddress add = packet.getAddress();
            packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, add, p);
            serverSocket.send(packet);

        } catch (Exception e) {
            System.out.println("sendAndReceive end.");
            e.printStackTrace();
            serverSocket.close();
        }

    }

    // get weather from Wh.txt text file.
    public synchronized String openFileAndGetWeather(String city){
        String result = "";
        try {
            Scanner scanner = new Scanner(new File("Wh.txt"));
            while(scanner.hasNext()){
                String[] temp = new String[5];
                String line = scanner.nextLine();
                temp = line.split(",");
                if(temp[0].equals(city)){
                    result = ("today "+temp[0]+" is "+temp[4]+" and "+temp[1]+" degrees ,tomorrow: "
                                +temp[2] +" , the day after tomorrow: "+temp[3]);
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}