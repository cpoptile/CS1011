/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class Die
 * Name: poptilec
 * Created 10/23/2019
 */

import java.util.Random;

/**
 * Course CS1011-071
 * Fall 2019
 * Die purpose: class creates a die object which can be rolled and have its value displayed
 *
 * @author poptilec
 * @version created on 10/23/2019 at 1:57 PM
 */
public class Die {

    private int numSides;
    private int currentValue;
    private Random roll = new Random();

    public static void main(String[] args) {
    }

    public Die(int numSides){
        if (numSides>100 || numSides<2){
            this.numSides = 6;
        }
        else{
            this.numSides = numSides;
        }
    }

    /**
     * This method returns the value of the side of the die that would be facing up
     * @return currentValue
     */
    public int getCurrentValue(){
        roll();
        return currentValue;
    }

    /**
     * This method uses the random class to determine a value for side of a die that would be facing up
     */
    public void roll(){
        currentValue = roll.nextInt(numSides)+1;
    }
}
