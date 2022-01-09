package com.company;

public class AirPort {

    private String portName;
    private int numOfLines;  // begin in 1?
    private int done = 0;


    // Constructor
    public AirPort(String name, int num){
        this.numOfLines = num;
        this.portName = name;
    }
    // Getters
    public int getNumOfLines() {
        return numOfLines;
    }
    public String getPortName() {
        return portName;
    }
    // Setters
    public void setNumOfLines(int numOfLines) {
        this.numOfLines = numOfLines;
    }
    public void setPortName(String portName) {
        this.portName = portName;
    }





    public synchronized int depart(int numOfFlight){
        while(numOfLines <= numOfFlight){ // not my turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("avlable line to depart: "+numOfLines);
        return numOfLines;
    }





    public int land(int numOfFlight){
        while(numOfLines <= numOfFlight){ // not my turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("avlable line to land: "+numOfLines);
        return numOfLines;
    }





    public synchronized void freeRunway(int numOfFlight, int runwayNum){
        numOfLines++;
        notifyAll();
        return;
    }



}

