import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    protected Node<T> sentinel;
    protected int size;

    public LinkedList() {
        this.sentinel = new Node<T>();
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrev(this.sentinel);
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void append(T t) {
        Node<T> node_ = new Node<T>(t);
        node_.setNext(this.sentinel);
        node_.setPrev(this.sentinel.getPrev());
        this.sentinel.getPrev().setNext(node_);
        this.sentinel.setPrev(node_);
        this.size++;
    }

    public void prepend(T t) {
        Node<T> node_ = new Node<T>(t);
        node_.setNext(this.sentinel.getNext());
        node_.setPrev(this.sentinel);
        this.sentinel.getNext().setPrev(node_);
        this.sentinel.setNext(node_);
        this.size++;


    }


    public T getHead() {
        return this.sentinel.getData();
    }

    public void insert(T t) {
        append(t);
    }

    public void next(Object... a) throws Exception {
        throw new Exception("This is an invalid method for this implementation of LinkedList");
    }

    public void reset() throws Exception {
        throw new Exception("This is an invalid method for this implementation of LinkedList");
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            Node<T> current = sentinel;

            @Override
            public boolean hasNext() {
                if(current.getNext() == null) return false;

                if(current.getNext() == sentinel){
                    current = sentinel;
                    return false;
                }

                return true;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements.");
                }
                current = current.getNext();
                return current.getData();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }
        };
        return it;
    }
}
