/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package SKerns_Lab6;

/**
 * This program creates a stack using a singly linked list and provides all the
 * methods needed to operate on the stack for the RPN program
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class LinkedStack {

    /**
     * This class creates a node for a linked list stack
     *
     * @author Stewart Kerns
     * @version 1.0
     */
    private class Node{
        //declare value to hold a double
        double value;
        //declare a Node next
        Node next;

        /**
         * This constructor sets the value
         * @param value
         * @param next
         */

        Node (double value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node top = null;

    public boolean empty(){
        return top == null;
    }

    public void push (double num){
        top = new Node(num, top);
    }

    public double pop(){
        if (empty()){
            throw new IllegalArgumentException(
                    "Stack is empty");
        }
        else {
            double value = top.value;
            top = top.next;
            return value;
        }
    }

    public double peek() {
        if (empty()){
            throw new IllegalArgumentException(
                    "Stack is empty");
        }
        else {
            return top.value;
        }
    }
}
