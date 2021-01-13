/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class Lab4
 * Name: poptilec
 * Created 10/2/2019
 */
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Course CS1011-071
 * Fall 2019
 * Lab4 purpose: This program consists of a game in which a user picks an option to grow a value either linearly or exponentially, winning the game if the user chose the option
 * that grows the value the largest at a randomly set stopping point
 *
 * @author poptilec
 * @version created on 10/2/2019 at 11:21 AM
 */
public class Lab4 {
    static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        // calls method to compute options
        options();
    }

    public static void options() {
        Scanner scan = new Scanner(System.in);
        // print out explanation and get option from user
        System.out.println("A stranger in a trenchcoat approaches you and presents to you two magic beans. The first bean grows a bean stalk exponentially while the second one grows " +
                "a bean stalk linearly. \nHowever, the soil can only sustain the stalks for an unknown amount of weeks. The stranger offers you a golden egg if you chose the " +
                "bean tha grows the tallest beanstalk at the end of the \nunknown weeks. Please enter 1 or 2 as your option");
        double option = scan.nextDouble();
        // assign values to amount of weeks and initial amounts
        int weeks = (int) (Math.random() * 40)+1;
        int i = 1;
        double one = (Math.random()*100);
        double two = .001;
        double growthOne = one;
        //print out values until stepper variable i is equal to the amount of weeks
        while (i <= weeks) {
            System.out.println("Week: " +i+ " Bean One: " +df.format(growthOne)+ " centimeters Bean Two: "+two+" centimeters");
            i++;
            growthOne += one;
            two *= 2;
        }
        // tell the user whether they won or lost the game based on their option chosen
        if (growthOne>two) {
            if (option == 1) {
                System.out.println("The soil ran out of nutrients on week " + (weeks+1) + ", so you got lucky and grew a beanstalk of "
                        + df.format(growthOne) + "centimeters \nWould you like to play again?(Please enter yes or no)");
                String j = scan.next();
                if (j.equals("yes")) {
                    options();
                }
                else {
                    System.out.println("Goodbye");
                }
            }
            else {
                System.out.println("The soil ran out of nutrients on week " + (weeks+1) + ", so you got unlucky and missed out the golden egg since the other bean" +
                        " grew a beanstalk of " + two + " centimeters \nWould you like to play again? (please enter yes or no)");
                String j = scan.next();
                if (j.equals("yes")) {
                    options();
                } else {
                    System.out.println("Goodbye");
                }
            }
        }
        else {
            if (option == 1) {
                System.out.println("The soil ran out of nutrients on week " + (weeks+1) + ", so you got unlucky and missed out on the golden egg since the other bean" +
                        " grew a beanstalk of " + two + " centimeters \nWould you like to play again?(Please enter yes or no)");
                String j = scan.next();
                if (j.equals("yes")) {
                    options();
                } else {
                    System.out.println("Goodbye");
                }
            }
            else {
                System.out.println("The soil ran out of nutrients on week  " + (weeks+1) + ", so you got lucky and grew a beanstalk of "
                        + two + " centimeters \nWould you like to play again? (please enter yes or no)");
                String j = scan.next();
                if (j.equals("yes")) {
                    options();
                } else {
                    System.out.println("Goodbye");
                }
            }

        }
    }

}

