import java.util.NoSuchElementException;

public class QueueAsLinkedList<T> implements Queue<T> {
    //fields
    private LinkedList<T> data;

    //constructor
    public QueueAsLinkedList(){
        data = new LinkedList<>();
    }

    //methods
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.remove(0);
    }

    @Override
    public void enqueue(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        data.add(element);
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.get(0);
    }
}
