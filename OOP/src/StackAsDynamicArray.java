import java.util.NoSuchElementException;

public class StackAsDynamicArray<T> implements Stack<T> {
    //fields
    private DynamicArrayBalanced<T> data;

    //constructor
    public StackAsDynamicArray(){
        data = new DynamicArrayBalanced<>();
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
        return data.get(data.size()-1);
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.remove(data.size()-1);
    }

    @Override
    public void push(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        data.add(element);
    }
}
