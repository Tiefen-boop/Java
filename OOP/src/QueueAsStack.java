import java.util.NoSuchElementException;

public class QueueAsStack<T> implements Queue<T> {
    //fields
    Stack<T> data;

    //constructor
    public QueueAsStack(){
        data = new StackAsLinkedList<>();
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
        return data.pop();
    }

    @Override
    public void enqueue(T element) {
        if (data.isEmpty()) {
            data.push(element);
            return;
        }
        T tmp = data.pop();
        enqueue(element);
        data.push(tmp);
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.peek();
    }
}
