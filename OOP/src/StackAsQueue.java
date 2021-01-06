import java.util.NoSuchElementException;

public class StackAsQueue<T> implements Stack<T> {
    //fields
    Queue<T> data;

    //constructors
    public StackAsQueue(){
        data = new CircularQueue<>();
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
        return data.peek();
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.dequeue();
    }

    @Override
    public void push(T element) {
        reverseData();
        data.enqueue(element);
        reverseData();
    }

    private void reverseData(){
        if (data.isEmpty()){
            return;
        }
        T tmp = data.dequeue();
        reverseData();
        data.enqueue(tmp);
    }
}
