public class DynamicArray<T> implements List<T> {
    //fields
    private Object[] data;

    //constructors
    public DynamicArray(){
        data = new Object[0];
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
        if (!contains(element))
            return false;
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
        return true;
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

    public boolean equals(DynamicArray<T> other) {
        if (other == null || data.length != other.data.length)
            return false;
        for (int i = 0; i < data.length; i++)
            if (!data[i].equals(other.data[i]))
                return false;
        return true;
    }
}