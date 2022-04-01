import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> sentinel;
    private int size;

    public LinkedList() {
        sentinel = new Node();
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void append(T t) {
        Node<T> node_ = this.sentinel;
        while (node_.getNext() != null) {
            node_ = node_.getNext();
        }

        node_.setNext(new Node<T>(t));
        this.size++;
    }

    public void prepend(T t) {
        Node<T> node_ = new Node<T>(t);
        node_.setNext(this.sentinel.getNext());
        this.sentinel.setNext(node_);
        this.size++;
    }


    public T getHead() {
        return null;
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
                return !(current.getNext() == sentinel || current.getNext() == null );
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
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
