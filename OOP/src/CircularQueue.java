import java.util.NoSuchElementException;

public class CircularQueue<T> implements Queue<T>{
    //fields
    private Link<T> last;

    //constructor
    public CircularQueue(){
        last = null;
    }

    //methods
    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T returnData = last.getNext().getData();
        if (last == last.getNext())
            last = null;
        else
            last.setNext(last.getNext().getNext());
        return returnData;
    }

    @Override
    public void enqueue(T element) {
        if (last==null){
            this.last = new Link<>(element);
            this.last.setNext(this.last);
            return;
        }
        Link<T> last = new Link<>(element, this.last.getNext());
        this.last.setNext(last);
        this.last = last;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.getNext().getData();
    }
}
