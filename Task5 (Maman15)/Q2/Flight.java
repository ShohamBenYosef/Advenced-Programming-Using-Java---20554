package com.company;

import java.util.Random;

public class Flight extends Thread{

    private int numOfFlight;
    private AirPort source;
    private AirPort target;

    final static int MAX_MSEC = 5000, MIN_MSEC = 2000;

    // Constructor
    public Flight(int numOfFlight, AirPort source, AirPort target){
        this.numOfFlight = numOfFlight;
        this.source = source;
        this.target = target;
    }

    // Getters
    public int getNumOfFlight() {
        return numOfFlight;
    }
    public AirPort getDeparture() {
        return source;
    }
    public AirPort getLanding() {
        return target;
    }

    // Setters
    public void setNumOfFlight(int numOfFlight) {
        this.numOfFlight = numOfFlight;
    }
    public void setDeparture(AirPort departure) {
        this.source = departure;
    }
    public void setLanding(AirPort landing) {
        this.target = landing;
    }

    // methods
    public void run(){
        super.run();


        int runwayNum = this.source.depart(numOfFlight);
        departAndLandingTime();
        this.source.freeRunway(numOfFlight, runwayNum);
        flightAirTime();
        runwayNum = this.target.land(numOfFlight);
        departAndLandingTime();
        this.target.freeRunway(numOfFlight,runwayNum);

    }


    private void departAndLandingTime(){
        Random random = new Random();
        try {
            sleep(random.nextInt(MAX_MSEC-MIN_MSEC) + MIN_MSEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void flightAirTime(){
        Random random = new Random();
        try {
            sleep(random.nextInt(MAX_MSEC-MIN_MSEC) + MIN_MSEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
