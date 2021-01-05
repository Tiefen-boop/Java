public class SetAsLinkedList<T> implements Set<T> {
    //fields
    private List<T> data;

    //constructors
    public SetAsLinkedList(){
        data = new LinkedList<T>();
    }

    //copy constructor
    public SetAsLinkedList(Set<T> other){
        data = new LinkedList<T>();
        Iterator<T> otherIterator = other.iterator();
        while (otherIterator.hasNext())
            add(otherIterator.next());
    }

    //methods
    public Iterator<T> iterator() {
        return data.iterator();
    }

    public int size() {
        return data.size();
    }

    public boolean add(T element) {
        if (data.contains(element))
            return false;
        data.add(element);
        return true;
    }

    public boolean contains(T element) {
        return data.contains(element);
    }

    public boolean remove(T element) {
        return remove(element);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean equals(Object other){
        if (!(other instanceof SetAsLinkedList<?> || ((SetAsLinkedList<?>) other).size() != size()))
            return false;
        Iterator<T> iterator = iterator();
        Iterator<?> otherIterator = ((LinkedList<?>) other).iterator();
        while (iterator.hasNext())
            if (!iterator.next().equals(otherIterator.next()))
                return false;
        return true;
    }
}
