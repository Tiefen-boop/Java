import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T>{
    //fields
    private Link<T> current;

    //constructors
    public LinkedListIterator(Link<T> current){
        this.current = current;
    }

    //methods
    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T returnData = current.getData();
        current = current.getNext();
        return returnData;
    }
}
