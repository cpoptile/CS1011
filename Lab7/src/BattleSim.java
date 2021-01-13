/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class BattleSim
 * Name: poptilec
 * Created 10/23/2019
 */

import java.util.Scanner;

/**
 * Course CS1011-071
 * Fall 2019
 * BattleSim purpose: BattleSim Driver for Battle Simulator 3000
 *
 * @author poptilec
 * @version created on 10/23/2019 at 1:58 PM
 */

public class BattleSim {
    /**
     * Ten-sided die to be used for checking initiative by all classes
     */
    public static final Die INITIATIVE_DIE = new Die(10);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Local variables
        // Include any variable that will need to be accessed throughout the program here

        // sentinel value for the game loop
        boolean play = true;
        // String used to determine the winner of the epic battle
        String victor = "";
        // game loop
        do {
            intro();
            // initialize game
            // Initialize the Warrior and Mugwump classes, set the current victor to "none"
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            victor = "none";

            // while neither combatant has lost all of their hit points, report status and battle!
            while (victor.equalsIgnoreCase("none")) {
                report(warrior, mugwump);
                victor = battle(warrior, mugwump, in);
            }
            // declare the winner
            victory(victor);
            // ask to play again
            play = playAgain(in);

        } while (play);
        System.out.println("Thank you for playing Battle Simulator 3000!");

    }

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        System.out.println("Welcome to Battle Simulator 3000! The world's more low tech battle simulator!\n" +
                "You are a Valiant Warrior defending your humble village from an evil Mugwump! Fight bravely, \n" +
                "or the citizens of your town will be the Mugwump's dinner!\n" +
                "\n" +
                "You have your Trusty Sword, which deals decent damage, but can be tough to hit with sometimes. \n" +
                "You also have your Shield of Light, which is not as strong as your sword, but is easier to deal \n" +
                "damage with.\n" +
                "\n" +
                "Let the epic battle begin!");
    }

    /**
     * This method handles the battle logic for the game.
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        int first = initiative();
        if (first == 1){
            System.out.println("The Warrior attacks first!");
            mugwump.takeDamage(warrior.attack(attackChoice(in)));
            if (mugwump.getHitPoints()> 0){
                warrior.takeDamage(mugwump.attack());
                if (warrior.getHitPoints() == 0){
                    return "mugwump";
                }
            }
            else{
                return "warrior";
            }
        }
        else {
            System.out.println("The Mugwump attacks first!");
            warrior.takeDamage(mugwump.attack());
            if (warrior.getHitPoints() > 0){
                mugwump.takeDamage(warrior.attack(attackChoice(in)));
                if (mugwump.getHitPoints() == 0){
                    return "warrior";
                }
            }
            else{
                return "mugwump";
            }
        }
        return "none";
    }

    /**
     * This method reports the status of the combatants
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println("Warrior HP: " + warrior.getHitPoints() + "\nMugwump HP: " + mugwump.getHitPoints());
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     *
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        System.out.println("How would you like to attack?\n1. Your Trusty Sword\n2. Your Shield of Light\nEnter choice: ");
        int type = in.nextInt();
        return type;
    }

    /**
     * Determines which combatant attacks first and returns the result. In the case of a tie,
     * re-roll.
     *
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        int winner = 0;
        int mug = 0;
        int war = 0;
        while (war==mug){
            mug = INITIATIVE_DIE.getCurrentValue();
            war = INITIATIVE_DIE.getCurrentValue();
        }
        if (war>mug){
            winner = 1;
        }
        else{
            winner = 2;
        }
        return winner;
    }

    /**
     * This method declares the victor of the epic battle
     *
     * @param victor the name of the victor of the epic battle
     */
    private static void victory(String victor) {
        if (victor.equals("mugwump")== true){
            System.out.println("The Mugwump has defeated you");
        }
        else{
            System.out.println("You've defeated the foul Mugwump!");
        }
    }

    /**
     * This method asks the user if they would like to play again
     *
     * @param in Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner in) {
        System.out.println("Would you like to play again?");
        String answer = in.next();
        boolean play;
        if (answer.charAt(0) == ('Y') || (answer.charAt(0) == ('y')) || answer.equalsIgnoreCase("yes")){
            play = true;
        }
        else {
            play = false;
        }
        return play;
    }
}