/*
Author: Daniel Beiers c3039134
Date: 10.4.2022
Project: SENG2200 Assignment 2
Description: A child class of the Linked List data structure to store the elements in descending order of area.
*/
public class SortedLinkedList<T extends PlanarShape> extends LinkedList<T>{

    //Default constructor
    public SortedLinkedList(){
        super();
    }

    //A type object is passed as a parameter and inserted into the linked list at the appropriate point.
    //PreCondition: If the list is empty, the new data is inserted after the sentinel
    //Post-Condition: Each element in the list is traversed until a node with less area is found and the new node inserted prior to this.
    //                If all nodes greater in area, than inserted at the end of the list.
    public void insertInOrder(T t){
        Node<T> newNode = new Node<T>(t);
        Node<T> currentNode = this.sentinel.getNext();
        if(this.size==0){
            newNode.setPrev(this.sentinel);
            newNode.setNext(this.sentinel);
            this.sentinel.setNext(newNode);
            this.sentinel.setPrev(newNode);
            size++;
        }
        else {
            while (currentNode != this.sentinel) {
                if (newNode.getData().compareTo(currentNode.getData()) >= 0) {
                    newNode.setNext(currentNode);
                    newNode.setPrev(currentNode.getPrev());
                    currentNode.getPrev().setNext(newNode);
                    currentNode.setPrev(newNode);
                    size++;
                    break;
                }

                currentNode = currentNode.getNext();
            }
            if (currentNode == this.sentinel) {
                newNode.setPrev(this.sentinel.getPrev());
                newNode.setNext(this.sentinel);
                this.sentinel.getPrev().setNext(newNode);
                this.sentinel.setPrev(newNode);
                size++;
            }
        }
    }

    //Method overridden from parent class to redirect request to the insertInOrder method.
    @Override
    public void insert(T t){
        insertInOrder(t);
    }

    //Method overridden from parent class to throw an unsupported exception error.
    @Override
    public void append(T t){
        throw new UnsupportedOperationException("Invalid method");
    }

    //Method overridden from parent class to throw an unsupported exception error.
    @Override
    public void prepend(T t){
        throw new UnsupportedOperationException("Invalid method");
    }
}
