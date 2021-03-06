public class DynamicArray<T> implements List<T> {
    //fields
    private Object[] data;

    //constructors
    public DynamicArray(){
        data = new Object[0];
    }

    //copy constructor
    public DynamicArray(List<T> other){
        data = new Object[0];
        Iterator<T> otherIterator = other.iterator();
        while (otherIterator.hasNext())
            add(otherIterator.next());
    }

    //methods
    private boolean rangeChecker(int index){
        if (index >= 0 & index < data.length)
            return true;
        return false;
    }

    public int size() {
        return data.length;
    }

    public void add(T element) {
        if (element == null)
            return;
        Object[] temp = new Object[data.length+1];
        for (int i = 0 ; i < data.length; i++)
            temp[i] = data[i];
        temp[temp.length-1] = element;
        data = temp;
    }

    public void add(int index, T element) {
        if (!rangeChecker(index) | element == null)
            return;
        Object[] temp = new Object[data.length+1];
        for (int i = 0 ; i < index; i++)
            temp[i] = data[i];
        temp[index] = element;
        for (int i = index ; i < data.length; i++)
            temp[i+1] = data[i];
        data = temp;
    }

    public T set(int index, T element) {
        if (!rangeChecker(index) | element == null)
            return null;
        T returnElement = (T)data[index];
        data[index] = element;
        return returnElement;
    }

    public T get(int index) {
        if (!rangeChecker(index))
            return null;
        return (T)data[index];
    }

    public boolean remove(T element) {
        Object[] temp = new Object[data.length-1];
        int i = 0;
        while (!data[i].equals(element)){
            temp[i] = data[i];
            i++;
        }
        while (i< data.length){
            temp[i] = data[i+1];
            i++;
        }
        data = temp;
        return true;
    }

    @Override
    public T remove(int index) {
        if (!rangeChecker(index))
            throw new IllegalArgumentException("Illegal index");
        Object[] temp = new Object[data.length-1];
        int i = 0;
        while (i<index){
            temp[i] = data[i];
            i++;
        }
        T returnData = (T) data[i];
        i++;
        while (i< data.length){
            temp[i] = data[i+1];
            i++;
        }
        data = temp;
        return returnData;
    }

    public boolean contains(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element))
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (data.length == 0)
            return true;
        return false;
    }

    public String toString() {
        if (size() == 0)
            return "[]";
        String string = "[ ";
        for (int i = 0; i < data.length; i++)
            if (i == (data.length - 1))
                string = string + data[i] + " ";
            else
                string = string + data[i] + ", ";
        return string + "]";
    }

    public boolean equals(Object other) {
        if (!(other instanceof DynamicArray<?>) || ((DynamicArray<?>) other).size() != size())
            return false;
        for (int i = 0; i < data.length; i++)
            if (!data[i].equals(((DynamicArray<?>) other).data[i]))
                return false;
        return true;
    }

    public Iterator<T> iterator() {
        return new DynamicArrayIterator<T>(this);
    }
}