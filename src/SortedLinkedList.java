import java.util.Iterator;

public class SortedLinkedList<T extends PlanarShape> extends LinkedList<T>{

    public SortedLinkedList(){
        super();
    }

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

    @Override
    public void insert(T t){
        insertInOrder(t);
    }
    @Override
    public void append(T t){
        throw new UnsupportedOperationException("Invalid method");
    }

    @Override
    public void prepend(T t){
        throw new UnsupportedOperationException("Invalid method");
    }
}
