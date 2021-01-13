/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class Mugwump
 * Name: poptilec
 * Created 10/23/2019
 */

import java.util.Random;

/**
 * Course CS1011-071
 * Fall 2019
 * Mugwump purpose: Class that creates the mugwump character and deals with its attacks and hit point values
 *
 * @author poptilec
 * @version created on 10/23/2019 at 1:58 PM
 */

public class Mugwump {

    private int hitPoints;
    private int maxHitPoints;
    private Die d20 = new Die(20);
    private Die d100 = new Die(100);
    private Die d10 = new Die(10);
    private Die d6 = new Die(6);


    public Mugwump(){
        setInitialHitPoints();
    }

    /**
     * This method returns the current hit points for the Mugwump
     * @return hit point value
     */
    public int getHitPoints(){
        return hitPoints;

    }

    /**
     * This method registers the attack damage done to the Warrior by the Mugwump
     */
    public void takeDamage(int damage){
        if ((hitPoints-damage) > maxHitPoints){
            hitPoints=maxHitPoints;
        }
        else if ((hitPoints-damage) >= 0){
            hitPoints-= damage;
        }
        else {
            hitPoints = 0;
        }
    }

    /**
     * This method handles the attack logic
     * @return the amount of damage an attack has caused, 0 if the attack misses or the Mugwump heals
     */

    public int attack() {
        int type = this.ai();
        int damage = 0;
        if (type == 1){
            if (d20.getCurrentValue() >= 12){
                damage += d6.getCurrentValue();
                damage += d6.getCurrentValue();
                System.out.println("The Mugwump hits you with his Razor-Sharp Claws for "+ damage+ " points of damage");

            }
            else{
                System.out.println("The Mugwump claws at you and misses");
            }
        }
        else if (type == 2){
            if (d20.getCurrentValue() >= 16){
                damage += d6.getCurrentValue();
                damage += d6.getCurrentValue();
                damage += d6.getCurrentValue();
                System.out.println("The Mugwump hits you with his Fangs of Death for "+ damage+ " points of damage");

            }
            else{
                System.out.println("The Mugwump snaps at you and misses");
            }
        }
        else if (type == 3){
            damage -= d6.getCurrentValue();
            System.out.println("The Mugwump licks its wounds, restoring itself with "+ damage+ " points of HP");

        }
        return damage;
    }

    /**
     * This method determines the initial hit points for the Mugwump
     * @return hit point value
     */
    private int setInitialHitPoints(){
        for(int i = 0; i < 10; i++){
            hitPoints += d10.getCurrentValue();
        }
        maxHitPoints = hitPoints;
        return hitPoints;
    }

    /**
     * This method determines what action the Mugwump performs
     * @return 1 for a Claw attack, 2 for a Bite, and 3 if the Mugwump licks its wounds, instead
     */
    private int ai() {
        Random rand = new Random();
        double temp = rand.nextInt(1);
        if(temp < 0.75){
            return 1;
        } else if (temp >= 0.75 && temp < 0.9){
            return 2;
        } else {
            return 3;
        }
    }
}
