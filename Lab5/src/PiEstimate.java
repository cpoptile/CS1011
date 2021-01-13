/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class PiEstimate
 * Name: poptilec
 * Created 10/9/2019
 */
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.text.DecimalFormat;

/**
 * Course CS1011-071
 * Fall 2019
 * PiEstimate purpose: Program estimates the value of pi based on the amount of points given by the user
 *
 * @author poptilec
 * @version created on 10/9/2019 at 11:05 AM
 */

public class PiEstimate {

    public static String best;
    public static int previous = 0;
    public static int correct;

    public static void main(String[] args) {
        getDots();
    }

    // Gets number of dots to be generated from user
    public static void getDots(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number of randomly generated points");
        if (scan.hasNextInt()){
            int points = scan.nextInt();
            if (points<0){
                System.out.println("Invalid input. Please try again");
                getDots();
            }
            generateCoordinates(points);
        }
        else{
            System.out.println("Invalid input. Please try again");
            getDots();
        }
    }

    // Generates coordinates for the circle
    public static void generateCoordinates(int p){
        Random rand = new Random();
        double total = p;
        double inside = 0;
        double x, y, tot;
        while (p>0){
            x = rand.nextDouble();
            y = rand.nextDouble();
            tot = (x*x)+(y*y);
            if (tot <= 1){
                inside++;
            }
            p--;
        }
        double estimate = (inside/total)*4;
        System.out.println("Your estimate of pi is: "+ estimate);
        bestGuess(estimate);
        newEstimate();
    }

    // Generates the best guess of Pi
    public static void bestGuess(double e){
        DecimalFormat df = new DecimalFormat("###.00000000");
        String actualPi = df.format(Math.PI);
        String estimate = df.format(e);
        correct = 0;
        for (int i = 0; i<estimate.length(); i++){
            if (actualPi.charAt(i) == estimate.charAt(i)){
                correct++;
            }
        }
        if (correct>previous){
            previous = correct;
            best = estimate;
        }
    }

    //Prompts for new estimate
    public static void newEstimate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like generate a new estimate for pi? (Enter y or n)");
        String answer = scan.nextLine();
        answer = answer.toUpperCase();
        if (answer.equals("Y")){
            getDots();
        }
        else if (answer.equals("N")){
            System.out.println("The best number generated was: " + best + " with " +(correct-1)+ " digits correct, making your closest estimate be " + best.substring(0,correct)+
                    "\nGoodbye");
        }
        else{
            System.out.println("Invalid answer. Please try again");
            newEstimate();
        }
    }
}
