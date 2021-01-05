public class SetAsDynamicArray<T> implements Set<T> {
    //fields
    private List<T> dynamicArray;

    //constructors
    public SetAsDynamicArray(){
         dynamicArray = new DynamicArrayBalanced<T>();
    }

    //copy constructor
    public SetAsDynamicArray(Set<T> other){
        dynamicArray = new DynamicArrayBalanced<T>();
        Iterator<T> otherIterator = other.iterator();
        while (otherIterator.hasNext())
            add(otherIterator.next());
    }

    //methods
    public Iterator<T> iterator() {
        return dynamicArray.iterator();
    }

    public int size() {
        return dynamicArray.size();
    }

    public boolean add(T element) {
        if (dynamicArray.contains(element))
            return false;
        dynamicArray.add(element);
        return true;
    }

    public boolean contains(T element) {
        return dynamicArray.contains(element);
    }

    public boolean remove(T element) {
        return remove(element);
    }

    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }

    public boolean equals(Object other){
        if (!(other instanceof SetAsDynamicArray<?> || ((SetAsDynamicArray<?>) other).size() != size()))
            return false;
        Iterator<T> iterator = iterator();
        Iterator<?> otherIterator = ((SetAsDynamicArray<?>) other).iterator();
        while (iterator.hasNext())
            if (!iterator.next().equals(otherIterator.next()))
                return false;
        return true;
    }
}
