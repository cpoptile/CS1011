/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class District
 * Name: poptilec
 * Created 11/05/2019
 */

/**
 * Course CS1011-071
 * Fall 2019
 * District purpose: Manages parking lots within a district
 *
 * @author poptilec
 * @version created on 11/05/2019 at 2:55 PM
 */

public class District {
    private ParkingLot[] lots;
    public static final int MAX_LOTS = 20;
    private int numLots;
    private int time;
    private int totalTimeClosed;

    /**
     * Constructor creates a district with an array that can hold
     * 20 ParkingLot objects
     */
    public District(){
        lots = new ParkingLot[MAX_LOTS];
    }

    /**
     * Creates and adds a ParkingLot object to the lots array
     * @param name name of the lot
     * @param capacity capacity of the lot
     * @return the index of the new lot or -1 if the lot was not added
     */
    public int addLot(String name, int capacity){
        int newIndex = numLots;
        if(newIndex<MAX_LOTS) {
            lots[newIndex] = new ParkingLot(name, capacity);
            numLots++;
        }
        // return the index of the new lot or -1 if the lot was not added.
        return newIndex<MAX_LOTS ? newIndex : -1;
    }

    /**
     * Returns the ParkingLot at given index
     * @param index index of lot chosen
     * @return ParkingLot
     */
    public ParkingLot getLot(int index){
        return lots[index];
    }

    /**
     * Returns the number of remaining parking spots in the district
     * @return the number of remaining parking spots in the district
     */
    public int getNumberOfSpotsRemaining() {
        int spots = 0;
        for (int x = 0; x<numLots; x++){
            spots+= lots[x].getNumberOfSpotsRemaining();
        }
        return spots;
    }

    /**
     * Returns the amount of time all three lots have been
     * simultaneously closed.
     * @return number of minutes all three lots have been closed
     */
    public int getMinutesClosed() {
        return totalTimeClosed;
    }

    /**
     * Checks the status of all three lots in the district and
     * returns true if they are all closed and false otherwise.
     * @return whether all three lots in the district are closed
     */
    public boolean isClosed() {
        int x = 0;
        int c = 0;
        while (x<numLots){
            if(lots[x].isClosed()){
                c++;
            }
            x++;
        }
        if (c==numLots){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Record a vehicle entering a lot at a specified time.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleEntry on lot1).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     * @param lotNumber Number of lot (should be 1, 2, or 3)
     * @param time Entry time in minutes since all lots were opened.
     */
    public void markVehicleEntry(int lotNumber, int time) {
        minutesClosed(time);
        lots[lotNumber].markVehicleEntry(time);
    }

    /**
     * Record a vehicle exiting a lot at a specified time.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleEntry on lot1).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     * @param lotNumber Number of lot (should be 1, 2, or 3)
     * @param time Entry time in minutes since all lots were opened.
     */
    public void markVehicleExit(int lotNumber, int time) {
        minutesClosed(time);
        lots[lotNumber].markVehicleExit(time);
    }

    /**
     * Calculates the amount of time all three lots have been
     * simultaneously closed.
     * @param time time in minutes in which the lots are being evaluated
     */
    private void minutesClosed(int time){
        if (isClosed()){
            totalTimeClosed += time - this.time;
            this.time = time;
        }
        else {
            this.time = time;
        }
    }

    /**
     * Returns the status of each parking lot in the district
     * Prints out name of lot and percentage full or "CLOSED"
     * if the lot is over 80.0% full
     * @return status of each of the lots in the district
     */
    public String toString(){
        String toString = "District status:\n";
        for (int x = 0; x<numLots;x++){
            toString+= "  "+lots[x].toString()+"\n";
        }
        return toString;
    }
}

