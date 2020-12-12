import java.util.NoSuchElementException;

public class DynamicArrayBalancedIterator<T> implements Iterator<T>{
    //fields
    private DynamicArrayBalanced<T> dynamicArrayBalanced;
    private int index;

    //constructors
    public DynamicArrayBalancedIterator(DynamicArrayBalanced<T> dynamicArrayBalanced){
        this.dynamicArrayBalanced = dynamicArrayBalanced;
        index = 0;
    }

    //methods
    public boolean hasNext() {
        return index < dynamicArrayBalanced.size();
    }

    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T returnData = dynamicArrayBalanced.get(index);
        index++;
        return returnData;
    }
}
