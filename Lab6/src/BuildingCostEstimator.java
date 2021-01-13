/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class BuildingCostEstimator
 * Name: poptilec
 * Created 10/16/2019
 */

/**
 * Course CS1011-071
 * Fall 2019
 * BuildingCostEstimator purpose: program is implemented by the House class in order to generate the cost of a house
 *
 * @author poptilec
 * @version created on 10/16/2019 at 2:06 PM
 */

public class BuildingCostEstimator {

    private double costToBuild;
    private int numFullBaths;
    private int numHalfBaths;
    private int numBedrooms;
    private int numWindows;
    private double numGarages;
    private int squareFeet;

    public static void main(String[] args) {

    }

    public BuildingCostEstimator(){
        this.costToBuild();
    }

    public void setNumHalfBaths(int numHalfBaths){
        this.numHalfBaths = numHalfBaths;
    }

    public void setNumFullBaths(int numFullBaths){
        this.numFullBaths = numFullBaths;
    }

    public void setNumBedrooms(int numBeds){
        this.numBedrooms = numBeds;
    }

    public void setNumWindows(int numWindows){
        this.numWindows = numWindows;
    }

    public void setNumGarages(double numGarages){
        this.numGarages = numGarages;
    }

    public void setSquareFeet(int sqFeet){
        this.squareFeet = sqFeet;
    }

    public int getNumHalfBaths(){
        return numHalfBaths;
    }

    public int getNumFullBaths(){
        return numFullBaths;
    }

    public int getNumBedrooms(){
        return numBedrooms;
    }

    public int getNumWindows(){
        return numWindows;
    }

    public double getNumGarages(){
        return numGarages;
    }

    public int getSquareFeet(){
        return squareFeet;
    }

    public double costToBuild(){
        costToBuild += getSquareFeet()*135;
        costToBuild += getNumFullBaths()*20000;
        costToBuild += getNumHalfBaths()*7000;
        costToBuild += getNumBedrooms()*3000;
        costToBuild += getNumWindows()*1000;
        costToBuild += getNumGarages()*8000;
        return costToBuild;
    }
}

