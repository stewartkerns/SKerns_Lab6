/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package SKerns_Lab6;

//import the Scanner class
import java.util.Scanner;
/**
 * This program allows the user to do basic arithmetic using Reverse Polish
 * Notation and allows them to do as many calculations as they would like
 * before quitting
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class RPNCalculator {

    /**
     * The main method welcomes the user, runs the RPN calculator as long as
     * the user wants and then prints a goodbye message
     * @param args a String array containing the command line arguments
     */
    public static void main(String[] args){
        //create a Scanner object
        Scanner keyboardIn = new Scanner(System.in);

        //print the welcome message
        welcome();

        //run the calculator method until the user chooses to quit
        useRPNCalculator(keyboardIn);

        //print the goodbye message
        goodbye();

        //close the keyboard
        keyboardIn.close();
    }

    public static void useRPNCalculator(Scanner keyboardIn){
        //declare a String to hold the user's input
        String userString;

        //use a do while loop to run the calculator until the user no longer
        //wants to
        do {
            //take user's input in and assign it to the string
            userString = userInput(keyboardIn);
            //create a new RPN object and pass the userString into the
            // constructor
            RPN rpn = new RPN(userString);

            //if the string is empty, don't execute anything
            if (!userString.isEmpty()) {
                //if the string is blank, don't run it through the calculator
                if (!userString.isBlank()) {
                    //run the input through the calculator and print the result
                    System.out.println(rpn.evaluate());
                }
            }
        //run while the string taken in is not empty
        } while (!userString.isEmpty());
    }

    /**
     * This method prompts the user for the calculation they would like to do
     * and then takes in their input before returning it
     * @param keyboardIn a Scanner object for taking in user input
     * @return String of the user's input
     */
    public static String userInput(Scanner keyboardIn){
        //prompt the user for input
        System.out.print("calc >");
        //return the user's input
        return keyboardIn.nextLine();
    }

    /**
     * This method welcomes the user to the program
     */
    public static void welcome(){
        System.out.println("RPN Calculator\n\nPlease enter a space between " +
                "operators and operands. (blank line to quit)");
    }

    /**
     * This method gives a goodbye message to the user
     */
    public static void goodbye(){
        System.out.println("\nBye!");
    }
}

