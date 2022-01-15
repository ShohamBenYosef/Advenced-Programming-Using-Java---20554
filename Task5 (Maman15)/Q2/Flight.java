
import java.util.Random;

public class Flight extends Thread{
    private int numOfFlight;
    private AirPort source;
    private AirPort target;
    Random random = new Random();

    final static int MAX_MSEC = 50, MIN_MSEC = 20; //

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


        System.out.println("Flight Number "+numOfFlight+" Is Ready To Fly From " + source.getPortName() + " To " + target.getPortName());

        int runwayNum = source.depart(numOfFlight);
        departAndLandingTime();
        this.source.freeRunway(numOfFlight, runwayNum);
        flightAirTime();
        runwayNum = this.target.land(numOfFlight);
        departAndLandingTime();
        this.target.freeRunway(numOfFlight,runwayNum);

    }


    public void departAndLandingTime(){
        System.out.println("Depart And Landing Time - For Flight Number " + this.numOfFlight);
        try {
            sleep(random.nextInt(MAX_MSEC-MIN_MSEC) + MIN_MSEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void flightAirTime(){
        System.out.println("Time On Air - For Flight Number " + this.numOfFlight);
        try {
            sleep(random.nextInt(MAX_MSEC-MIN_MSEC) + MIN_MSEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
