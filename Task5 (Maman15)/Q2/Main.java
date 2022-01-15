import java.util.Random;


public class Main {

    public static void main(String[] args) {


        AirPort airPort1 = new AirPort("Tel Aviv", 3);
        AirPort airPort2 = new AirPort("New York", 3);
        AirPort airPort3 = new AirPort("London", 3);

        AirPort[] airPorts = {airPort1, airPort2, airPort3};
        Flight[] f = new Flight[10];
        Random r = new Random();

        for (int i = 1; i < f.length; i++) {
            f[i] = new Flight(i, airPorts[r.nextInt(3)], airPorts[r.nextInt(3)]);
            f[i].start();
        }
    }
}