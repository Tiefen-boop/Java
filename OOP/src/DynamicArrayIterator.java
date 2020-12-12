import java.util.NoSuchElementException;

public class DynamicArrayIterator<T> implements Iterator<T>{
    //fields
    private DynamicArray<T> dynamicArray;
    private int index;

    //constructors
    public DynamicArrayIterator(DynamicArray<T> dynamicArray){
        this.dynamicArray = dynamicArray;
        index = 0;
    }

    //methods
    public boolean hasNext() {
        return index < dynamicArray.size();
    }

    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T returnData = dynamicArray.get(index);
        index++;
        return returnData;
    }
}
