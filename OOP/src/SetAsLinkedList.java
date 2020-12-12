public class SetAsLinkedList<T> implements Set<T> {
    //fields
    private List<T> linkedList;

    //constructors
    public SetAsLinkedList(LinkedList<T> linkedList){
        this.linkedList = linkedList;
    }

    //methods
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }

    public int size() {
        return linkedList.size();
    }

    public boolean add(T element) {
        if (linkedList.contains(element))
            return false;
        linkedList.add(element);
        return true;
    }

    public boolean contains(T element) {
        return linkedList.contains(element);
    }

    public boolean remove(T element) {
        return remove(element);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
