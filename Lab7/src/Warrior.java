/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class Warrior
 * Name: poptilec
 * Created 10/23/2019
 */

/**
 * Course CS1011-071
 * Fall 2019
 * Warrior purpose: Class that creates the warrior character and deals with its attacks and hit point values
 *
 * @author poptilec
 * @version created on 10/23/2019 at 1:58 PM
 */
public class Warrior {

    private int hitPoints;
    private Die d10 = new Die(10);
    private Die d20 = new Die(20);
    private Die d8 = new Die(8);
    private Die d4 = new Die(4);
    

    public Warrior(){
        setInitialHitPoints();
    }

    /**
     * This method returns the current hit point value of the warrior
     * @return hit point value
     */
    public int getHitPoints(){
        return hitPoints;
    }

    /**
     * This method registers the attack damage done to the Warrior by the Mugwump
     */
    public void takeDamage(int damage){
        if ((hitPoints-damage) >= 0){
            hitPoints-= damage;
        }
        else {
            hitPoints = 0;
        }
    }

    /**
     * This method handles the attack logic
     * @return the amount of damage an attack has caused, 0 if the attack misses
     */
    public int attack(int type){
        int damage = 0;
        if (type == 1){
            if (d20.getCurrentValue() >= 12){
                damage += d8.getCurrentValue();
                damage += d8.getCurrentValue();
                System.out.println("You hit the Mugwump with your Trusty Sword for "+ damage+ " points of damage");
            }
            else{
                System.out.println("You swing your sword and miss the foul creature");

            }
        }
        else if (type == 2){
            if (d20.getCurrentValue() >= 8){
                damage += d4.getCurrentValue();
                damage += d4.getCurrentValue();
                System.out.println("You hit the Mugwump with your Shield of Light for "+ damage+ " points of damage");

            }
            else{
                System.out.println("You miss");
            }
        }
        return damage;
    }

    /**
     * This method determines the initial hit points for the warrior
     * @return hit point value
     */
    private int setInitialHitPoints(){
        for(int i = 0; i < 6; i++){
            hitPoints += d10.getCurrentValue();
        }
        return hitPoints;
    }
}
