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
    /* Setters
    public void setNumOfLines(int numOfLines) {
        this.numOfLines = numOfLines;
    }
    public void setPortName(String portName) {
        this.portName = portName;
    }
     */



    public synchronized int depart(int numOfFlight){
        System.out.println("flight number " + numOfFlight + " want to depart.");
        while(numOfLines == 0){ // not my turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print( numOfFlight + " depart from line " + numOfLines);
        numOfLines--;
        System.out.println(" there is "+numOfLines+" more lines..");
        return numOfLines;
    }





    public synchronized int land(int numOfFlight){
        while(numOfLines == 0){ // not my turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("land: "+numOfLines);
        numOfLines--;
        System.out.println("there is "+numOfLines+" more lines..");
        return numOfLines;
    }





    public synchronized int freeRunway(int numOfFlight, int runwayNum){
        numOfLines++;
        System.out.println("there is "+numOfLines+" more lines in " + getPortName());
        notifyAll();
        return numOfLines;
    }





}

