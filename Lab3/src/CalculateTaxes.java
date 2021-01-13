/*
 * Course: CS1011-071
 * Fall 2019
 * File header contains class CalculateTaxes
 * Name: poptilec
 * Created 9/25/2019
 */
import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

/**
 * Course CS1011-071
 * Fall 2019
 * CalculateTaxes purpose: Program displays the estimated taxes a user would need to pay and their effective tax rate based on inputted earned income and martial status
 *
 * @author poptilec
 * @version created on 9/25/2019 at 2:04 PM
 */

public class CalculateTaxes {

    //global variables initialized with values of tax brackets
    final static double s1 = 9700*.1;
    final static double j1 = 19400*.1;
    final static double s2 = 29775*.12;
    final static double j2 = 59550*.12;
    final static double s3 = 44725*.22;
    final static double j3 = 89450*.22;
    final static double s4 = 76525*.24;
    final static double j4 = 153050*.24;
    final static double s5 = 43375*.32;
    final static double j5 = 86750*.32;
    final static double s6 = 306200*.35;
    final static double j6 = 204150*.35;
    static DecimalFormat df = new DecimalFormat("#.00");

    public static void main(String[] args) {
        //calls filerType method
        filerType();
    }

    public static void filerType(){
        //method gets filer type from user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you a single filer or married joint filer? (Please enter 's' or 'j' accordingly)");
        String status = scan.nextLine();
        if (status.equals("s")) {
            System.out.println("Please enter your estimated earned income for 2019");
            double income = scan.nextDouble();
            single(income);
        }
        else if (status.equals("j")) {
            System.out.println("Please enter your estimated earned income for 2019");
            double income = scan.nextDouble();
            joint(income);
        }
        else {
            //calls filerType method again if input is invalid
            System.out.println("Invalid response, please try again");
            filerType();
        }
    }

    public static void single(double i) {
        double tax = 0.00;
        double xtra = 0.00;
        //method uses user input of income to determine the appropriate bracket and estimated taxes
        if (i>510300) {
            xtra = (i-510301)*.37;
            tax += xtra+s1+s2+s3+s4+s5+s6;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>204100){
            xtra = (i-204100)*.35;
            tax += xtra+s1+s2+s3+s4+s5;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>160725){
            xtra = (i-160725)*.32;
            tax += xtra+s1+s2+s3+s4;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>84200){
            xtra = (i-84200)*.24;
            tax += xtra+s1+s2+s3;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>39475){
            xtra = (i-39475)*.22;
            tax += xtra+s1+s2;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>9700){
            xtra = (i-9700)*.12;
            tax += xtra+s1;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else{
            tax = i*.10;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
    }

    public static void joint(double i) {
        double tax = 0;
        double xtra = 0;
        //method uses user input of income to determine the appropriate bracket and estimated taxes
        if (i>612350) {
            xtra = (i-612350)*.37;
            tax += xtra+j1+j2+j3+j4+j5+j6;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>408200){
            xtra = (i-408200)*.35;
            tax += xtra+j1+j2+j3+j4+j5;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>321450){
            xtra = (i-321450)*.32;
            tax += xtra+j1+j2+j3+j4;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>168400){
            xtra = (i-168400)*.24;
            tax += xtra+j1+j2+j3;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>78950){
            xtra = (i-78950)*.22;
            tax += xtra+j1+j2;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else if (i>19400){
            xtra = (i-19400)*.12;
            tax += xtra + j1;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
        else{
            tax = i*.10;
            String taxx = df.format(tax);
            System.out.println("Your estimated taxes for 2019 are: $" + taxx + "\nThis results in a "+ rate(i,tax) +"% effective tax rate");
        }
    }
    public static double rate(double i, double t){
        // method computes and returns effective tax rate using income and tax
        double rate = (t/i)*100;
        return Math.round(rate*100)/100.0;
    }
}

