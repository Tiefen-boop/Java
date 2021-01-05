import java.util.NoSuchElementException;

public class QueueAsDynamicArray<T> implements Queue<T> {
    //fields
    private DynamicArrayBalanced<T> data;

    //constructor
    public QueueAsDynamicArray(){
        data = new DynamicArrayBalanced<>();
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
