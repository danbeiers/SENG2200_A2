/*
Author: Daniel Beiers c3039134
Date:
Project: SENG2200 Assignment 2
Description: This class defines a node to be used as data carrier that references an object payload, and also points to a
'next' and 'previous' node.
Refactored to take generic object for payload.
 */
public class Node<T> {
    //Private variables indicating the node pointers and the payload of the node.
    private Node prev;
    private Node next;
    private T data;

    //Empty constructor
    public Node(){
        prev = null;
        next = null;
        data = null;
    }

    //Generic getters and setters for nodes and payload
    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setData(T data) {
        this.data = data;
    }
}
