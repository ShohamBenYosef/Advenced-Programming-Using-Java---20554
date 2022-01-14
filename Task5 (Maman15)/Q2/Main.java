package com.company;

public class Main {

    public static void main(String[] args) {
        

        AirPort airPort1 = new AirPort("TLV", 2);
        AirPort airPort2 = new AirPort("NY", 1);
/*
        Flight f1 = new Flight(1,airPort1, airPort2);
        Flight f2 = new Flight(2,airPort1, airPort2);
        Flight f3 = new Flight(3,airPort1, airPort2);
        f1.start();
        f2.start();
        f3.start();
*/

        Flight[] f = new Flight[11];

        for (int i = 1 ; i < f.length; i++){

            f[i] = new Flight(i,airPort1, airPort1);

            if(Math.random() < 0.5) {
                f[i].setDeparture(airPort1);
                f[i].setLanding(airPort2);
            } else {
                f[i].setDeparture(airPort2);
                f[i].setLanding(airPort1);
            }
            f[i].start();
        }


    }

}
