/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class SmallPrograms
 * Name: poptilec
 * Created 9/18/2019
 */
import java.util.Scanner;

/**
 * Course CS1011-071
 * Fall 2019
 * SmallPrograms purpose: This program consists of five methods that aim to:
 * return a negative of a number
 * return how many pennies are in a dollar amount
 * return the last half of a string with an even amount of characters
 * return an initialization statement given a variable and value
 * return a fraction as a floating point number
 *
 * @author poptilec
 * @version created on 9/18/2019 at 10:27 AM
 */
public class SmallPrograms {

    public static void main(String[] args) {
        // main method is used to call all other methods
        negate();
        howManyPennies();
        lastHalf();
        makeInitialization();
        fraction();
    }
    public static void negate(){
        // method negates number given as an input from user
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Negate\nEnter an integer value: ");
        int x = scan.nextInt();
        //negate integer with unary operator
        x = -x;
        System.out.println("Result: " + x);
    }
    public static void howManyPennies(){
        // method computes how many pennies are in a given dollar amount
        Scanner scan = new Scanner(System.in);
        System.out.println("2. How Many Pennies\nEnter a dollar amount: ");
        double p = scan.nextDouble();
        //multiply by 100 and cast double as int
        p = p*100;
        System.out.println("Result: " + (int)p);
    }
    public static void lastHalf(){
        // method prints last half of a word given by user
        Scanner scan = new Scanner(System.in);
        System.out.println("3. Last Half\nEnter an even lettered word: ");
        String word = scan.nextLine();
        //return last half of string using .substring
        System.out.println("Result: " + word.substring(word.length()/2));
    }
    public static void makeInitialization(){
        // method prints out a line of code initializing a variable to a value both given by the user
        Scanner scan = new Scanner(System.in);
        System.out.println("4. Make Initialization\nEnter a name: ");
        String name = scan.nextLine();
        System.out.println("Enter an integer value: ");
        int i = scan.nextInt();
        System.out.println("Result: int " +name+" = " +i +";");
    }
    public static void fraction(){
        // method computes the decimal form of a fraction when user inputs a numerator and denominator
        Scanner scan = new Scanner(System.in);
        System.out.println("5. Fraction\nEnter a numerator: ");
        float n = scan.nextFloat();
        System.out.println("Enter a denominator: ");
        float d = scan.nextFloat();
        System.out.println("Result: " + (n/d));
    }
}