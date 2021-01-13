/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class ParkingLot
 * Name: poptilec
 * Created 11/13/2019
 */
import java.text.DecimalFormat;

/**
 * Course CS1011-071
 * Fall 2019
 * ParkingLot purpose: ParkingLot class creates a parking lot given a capacity and name(defaulted to "test" if not given)
 * Methods include handling the entry and exit of a vehicle, testing whether the lot is closed, and returning the total amount of time the lot was closed
 *
 * @author poptilec
 * @version created on 11/13/2019 at 2:55 PM
 */
public class ParkingLot {
    public static final double CLOSED_THRESHOLD = 80.0;
    private final String name;
    private int capacity;
    private int numberOfSpotsRemaining;
    private int time = 0;
    private int totalTimeClosed = 0;
    private DecimalFormat df = new DecimalFormat("#.#");

    /**
     * Creates a ParkingLot object with a default name of "test"
     * and capacity
     * @param capacity the maximum number of cars the lot intends to hold
     */
    public ParkingLot(int capacity){
        this.capacity = capacity;
        name = "test";
        numberOfSpotsRemaining = capacity;
    }

    /**
     * Constructor creates a ParkingLot object with a given name and capacity
     * @param name Name of parking lot
     * @param capacity Number of cars lot is expected to hold
     */
    public ParkingLot(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        numberOfSpotsRemaining = capacity;
    }

    /**
     * Returns the total number of minutes the parking lot has been closed for
     * @return the number total number of minutes the parking lot has been closed for
     */
    public int getMinutesClosed(){
        return totalTimeClosed;
    }

    /**
     * Returns the name of the parking lot
     * @return name of parking lot
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the number of remaining parking spots in the lot
     * @return the number of remaining parking spots in the lot
     */
    public int getNumberOfSpotsRemaining(){
        return numberOfSpotsRemaining;
    }

    /**
     * Returns the percentage of the lot that is full
     * @return percentage of the lot that is full
     */
    public double getPercentFull(){
        double percent = ((double) (capacity-getNumberOfSpotsRemaining()) / capacity) * 100;
        return percent;
    }

    /**
     * Returns true if the lot is closed, false otherwise
     * @return if the lot is closed or not
     */
    public boolean isClosed(){
        if(getPercentFull()>=CLOSED_THRESHOLD){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Records a vehicle entering the lot
     * @param time entry time of vehicle
     */
    public void markVehicleEntry(int time){
        if(time>=this.time){
            if (isClosed()){
                numberOfSpotsRemaining--;
                totalTimeClosed += time - this.time;
                this.time =time;
            }
            else{
                numberOfSpotsRemaining--;
                this.time = time;
            }
        }
    }

    /**
     * Records a vehicle exiting the lot
     * @param time exit time of vehicle
     */
    public void markVehicleExit(int time){
        if(time>=this.time){
            if (isClosed()){
                numberOfSpotsRemaining++;
                totalTimeClosed += time - this.time;
                this.time = time;
            }
            else{
                numberOfSpotsRemaining++;
                this.time = time;
            }
        }
    }

    /**
     * Returns the status of each parking lot
     * Prints out name of lot and percentage full or "CLOSED"
     * if the lot is over 80.0% full
     * @return status of the lot
     */
    public String toString(){
        if (getPercentFull()>=CLOSED_THRESHOLD){
            return "Status for " +name+" parking lot: "+(capacity-getNumberOfSpotsRemaining())+
                    " vehicles (CLOSED)";
        }
        else {
            return "Status for " + name + " parking lot: " + (capacity - getNumberOfSpotsRemaining()) +
                    " vehicles (" + df.format(getPercentFull()) + "%)";
        }
    }

}
