import java.util.NoSuchElementException;

public class StackAsLinkedList<T> implements Stack<T> {
    //fields
    private LinkedList<T> data;

    //constructor
    public StackAsLinkedList(){
        data = new LinkedList<>();
    }

    //methods
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.get(0);
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.remove(0);
    }

    @Override
    public void push(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        data.addFirst(element);
    }
}
