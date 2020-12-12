import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T>{
    //fields
    private LinkedList<T> linkedList;
    private int index;

    //constructors
    public LinkedListIterator(LinkedList<T> linkedList){
        this.linkedList = linkedList;
        index = 0;
    }

    //methods
    public boolean hasNext() {
        return index < linkedList.size();
    }

    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T returnData = linkedList.get(index);
        index++;
        return returnData;
    }
}
