import java.util.Iterator;

public class LinkedList<T> implements Iterator {

    private Node sentinel;

    public void prepend(T t){

    }

    public void append(T t){

    }

    public T getHead(){
        return null;
    }

    public void insert(T t){
        append(t);
    }

    public void next(Object ...a) throws Exception {
        throw new Exception("This is an invalid method for this implementation of LinkedList");
    }
    public void reset() throws Exception {
        throw new Exception("This is an invalid method for this implementation of LinkedList");
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
