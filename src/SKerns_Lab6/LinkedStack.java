/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package SKerns_Lab6;

/**
 * This program TODO
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class LinkedStack {

    /**
     * This class TODO
     *
     * @author Stewart Kerns
     * @version 1.0
     */
    private class Node{
        double value;
        Node next;

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
            //TODO
            System.out.println("empty!");
            return 0.0;  //TODO delete this
        }
        else {
            double value = top.value;
            top = top.next;
            return value;
        }
    }

    public double peek() {
        if (empty()){
            //TODO
            System.out.println("empty!");
            return 0.0;  //TODO delete this
        }
        else {
            return top.value;
        }
    }
}
