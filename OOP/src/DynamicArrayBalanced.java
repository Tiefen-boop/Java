public class DynamicArrayBalanced<T> implements List<T> {
    //constants
    private static final int DEFAULT_CAPACITY = 16;

    //fields
    private Object[] data;
    private int size;
    private int incrementSize;

    //constructors
    public DynamicArrayBalanced(){
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        incrementSize = DEFAULT_CAPACITY;
    }

    public DynamicArrayBalanced (int initialCapacity){
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("initialCapacity has to be positive");
        data = new Object[initialCapacity];
        size = 0;
        incrementSize = initialCapacity;
    }

    //copy constructors
    public DynamicArrayBalanced(List<T> other){
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        incrementSize = DEFAULT_CAPACITY;
        Iterator<T> otherIterator = other.iterator();
        while (otherIterator.hasNext())
            add(otherIterator.next());
    }

    public DynamicArrayBalanced(List<T> list, int initialCapacity){
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("initialCapacity has to be positive");
        data = new Object[initialCapacity];
        size = 0;
        incrementSize = initialCapacity;
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext())
            add(iterator().next());
    }

    public int size() {
        return size;
    }

    private boolean rangeCheck(int index){
        if (index >= 0 & index < size)
            return true;
        return false;
    }

    private void ensureCapacity(){
        if (size() < data.length)
            return;
        Object[] temp = new Object[data.length+incrementSize];
        for (int i = 0; i < data.length; i++)
            temp[i] = data[i];
        data = temp;
    }
    public void add(T element) {
        if (element == null)
            return;
        data[size] = element;
        size++;
        ensureCapacity();
    }

    public void add(int index, T element) {
        if (element == null || !rangeCheck(index))
            return;
        for (int i = index; i <= size; i++) {
            Object temp = data[i];
            data[i] = element;
            element = (T)temp;
        }
        size++;
        ensureCapacity();
    }

    public T set(int index, T element) {
        if (element == null || !rangeCheck(index))
            return null;
        T returnData = (T)data[index];
        data[index] = element;
        return returnData;
    }

    public T get(int index) {
        if (!rangeCheck(index))
            return null;
        return (T)data[index];
    }

    public boolean remove(T element) {
        if (element == null)
            return false;
        for (int i = 0; i < size; i++)
            if (data[i].equals(element)){
                size--;
                for (int j = i; j < size; j++) {
                    data[j] = data[j+1];
                }
                return true;
            }
        return false;
    }

    @Override
    public T remove(int index) {
        if (!rangeCheck(index))
            throw new IllegalArgumentException("Illegal index");
        T returnData = (T) data[index];
        for (int i = index; i < size()-1; i = i + 1)
            data[i] = data[i+1];
        size = size - 1;
        return returnData;
    }

    public boolean contains(T element) {
        if (element == null)
            return false;
        for (int i = 0; i < size; i++)
            if (data[i].equals(element))
                return true;
        return false;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public String toString(){
        if (size == 0)
            return "[]";
        String string = "[ ";
        for (int i = 0; i < size - 1; i++)
            string = string + data[i] + ", ";
        string = string + data[size-1] + " ]";
        return string;
    }

    public boolean equals(Object other) {
        if (!(other instanceof DynamicArrayBalanced<?>) || ((DynamicArrayBalanced<?>) other).size != size)
            return false;
        for (int i = 0; i < size; i++)
            if (!data[i].equals(((DynamicArrayBalanced<?>) other).data[i]))
                return false;
        return true;
    }

    public Iterator<T> iterator() {
        return new DynamicArrayBalancedIterator<T>(this);
    }
}
