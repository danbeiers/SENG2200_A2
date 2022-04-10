/*
Author: Daniel Beiers c3039134
Date: 10.4.2022
Project: SENG2200 Assignment 2
Description: Standard circular Linked List data structure for generic type casting. Implements an interator.
             Contains only the methods stipulated by the specification.
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    //Private variables for defining the Sentinel node of the struct and the size of the linked list.
    protected Node<T> sentinel;
    protected int size;

    //Default constructor to initialise sentinel node and size.
    public LinkedList() {
        this.sentinel = new Node<T>();
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrev(this.sentinel);
        this.size = 0;
    }

    //Getter method for the private size variable
    public int getSize() {
        return this.size;
    }

    //This method takes the class type object as a parameter and adds it to the end of the linked list.
    //Pre-Condition: None
    //Post-Condition: Data object is added to the end of the linked list in a new node ands size incremented.
    public void append(T t) {
        Node<T> node_ = new Node<T>(t);
        node_.setNext(this.sentinel);
        node_.setPrev(this.sentinel.getPrev());
        this.sentinel.getPrev().setNext(node_);
        this.sentinel.setPrev(node_);
        this.size++;
    }

    //This method takes the class type object as a parameter and adds it to the start of the linked list.
    //Pre-Condition: None
    //Post-Condition: Data object is added to the start of the linked list in a new node ands size incremented.
    public void prepend(T t) {
        Node<T> node_ = new Node<T>(t);
        node_.setNext(this.sentinel.getNext());
        node_.setPrev(this.sentinel);
        this.sentinel.getNext().setPrev(node_);
        this.sentinel.setNext(node_);
        this.size++;


    }

    //Method to return the data item at the start of the linked list.
    //Pre-Condition: None
    //Post-Condition: Returns null if empty list, otherwise the data contained by the first node.
    public T getHead() {
        return this.sentinel.getData();
    }

    //Any call to this method gets re-directed to the 'append()' method with the same data object parameter.
    //Pre-Condition: None
    //Post-Condition: The passed parameter is added to the end of the linked list.
    public void insert(T t) {
        append(t);
    }

    //Any call to this method is returned an error message with an arbitrary amount of object arguments.
    //Pre-Condition: None
    //Post-Condition: Throws an invalid method exception.
    public void next(Object... a) throws Exception {
        throw new Exception("This is an invalid method for this implementation of LinkedList");
    }

    //Pre-Condition: None
    //Post-Condition: Throws an invalid method exception.
    public void reset() throws Exception {
        throw new Exception("This is an invalid method for this implementation of LinkedList");
    }

    //Implementation of the comparable interface.
    //An iterator to traverse over the elements of the Linked List.
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            Node<T> current = sentinel;

            //Pre-Condition: Checks that the next node is not null and is not the sentinel node
            //Post-Condition: Returns true if there is a valid next node in the linked list.
            @Override
            public boolean hasNext() {
                if(current.getNext() == null) return false;

                if(current.getNext() == sentinel){
                    current = sentinel;
                    return false;
                }

                return true;
            }

            //Pre-Condition: If there is no valid next node, throws an exception error.
            //Post-Condition: Iterates to the next item in the linked list and returns the data object contained in that node.
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements.");
                }
                current = current.getNext();
                return current.getData();
            }

            //This method is not implemented in the assignment.
            //Pre-Condition: None
            //Post-Condition: Throws an unsupported method exception.
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }
        };
        return it;
    }
}
