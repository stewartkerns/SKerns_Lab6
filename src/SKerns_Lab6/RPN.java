/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package SKerns_Lab6;

//import the scanner class
import java.util.Scanner;

/**
 * This program uses a stack to create all the logic needed to make a Reverse
 * Polish Notation calculator. It can take in a string of operands and
 * operators through the evaluate method and which will return the calculations
 * requested.
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class RPN {

    //create a LinkedStack object
    LinkedStack stack = new LinkedStack();
    //declare a string that will hold the input for the calculations
    private String userString;
    //declare two doubles which will be the operands in calculations and the
    //result of the calculations
    double dbl1, dbl2, result;

    /**
     * This constructor takes in a users' string and sets it to userString, it
     * also initializes dbl2 and dbl1 to 0
     * @param userString a String of operators and operands to be calculated by
     *                   reverse polish notation
     */
    public RPN(String userString){
        //set userString to the userString taken in
        this.userString = userString;
        //initialize both dbl1 and dbl2 to 0
        dbl2 = 0;
        dbl1 = 0;
    }

    /**
     * This method uses the user's string to push operands onto the stack when
     * it finds an operator, it does the required operation and then pushes the
     * result back onto the stack until the string is empty
     */
    private void stringIntoStack() {
        //Create a scanner object using the userString
        Scanner scanString = new Scanner(userString);

        //Scan the string until it's empty
        while (scanString.hasNext()) {
            //if the string has a double on it, push it to the stack
            if (scanString.hasNextDouble()) {
                stack.push(scanString.nextDouble());
            }

            //if it's not a double, do the required operation
            else {
                //get the operator as the next value that's not whitespace
                char operator = scanString.next().charAt(0);

                //pop the two operands
                dbl2 = popOperands();
                dbl1 = popOperands();

                //do the required operation using the operator
                operation(operator);

                //push the result back onto the stack
                stack.push(result);
            }
        }
        //close the Scanner object
        scanString.close();
    }

    /**
     * This method checks that the stack is empty once the entire string has
     * been gone through by popping the stack to result. If the stack is not
     * empty it will tell the user that there were not enough operators
     */
    private void checkResult(){
        //pop the stack into result
        result = stack.pop();

        //if the stack isn't empty, tell the user there weren't enough operators
        if (!stack.empty()){
            throw new IllegalArgumentException("Not enough operators");
        }
    }

    /**
     * This method runs the user's string through stringIntoStack method which
     * pushes each operand onto the stack and does operations as needed until
     * the string is empty.  It then calls checkResult which ensures that enough
     * operators were used and then returns the result
     *
     * @return double value of the result of calculations
     */
    public double evaluate(){
        //pass the string into the stack and do operations as needed
        stringIntoStack();
        //check that the enough operators were used
        checkResult();
        //return the result of the calculations
        return result;
    }

    /**
     * This method checks that there is another operand to make a calculation
     * on and if there is, then it returns the popped operand off the stack
     * @return double value of the popped stack
     */
    private double popOperands(){
        //check if the stack is empty and if so, throw an error
        if (stack.empty()){
            throw new IllegalArgumentException("Too many operators");
        }
        //return the popped value off the stack
        return stack.pop();
    }

    /**
     * This method does the math of the program by using a switch to evaluate
     * which operator was entered and throw an error if an invalid operator is
     * used
     * @param operator char value of the operator entered by the user
     */
    private void operation(char operator){
        //use a switch to determine which operation to do based on the operator
        switch (operator){
            //do addition
            case '+':
                result = dbl1 + dbl2;
                break;

            //do subtraction
            case '-':
                result = dbl1 - dbl2;
                break;

            //do multiplication
            case '*':
                result = dbl1 * dbl2;
                break;

            //do division
            case '/':
                result = dbl1 / dbl2;
                break;

            //throw an error if an invalid operator was used
            default:
                throw new IllegalArgumentException("Unknown operator: " +
                        operator);
        }
    }

    /**
     * This setter is used to set the userString to the input received
     * @param userString a String of operators and operands
     */
    public void setUserString(String userString) {
        //set userString
        this.userString = userString;
    }
}
