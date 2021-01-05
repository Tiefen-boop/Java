public class LinkedList<T> implements List<T>{
    //fields
    private Link<T> first;

    //constructors
    public LinkedList(){
        first = null;
    }

    public LinkedList(Link<T> first){
        this.first = first;
    }

    //copy constructor
    public LinkedList(List<T> other){
        first = null;
        Iterator<T> otherIterator = other.iterator();
        while (otherIterator.hasNext())
            add(otherIterator.next());
    }

    //methods
    public int size() {
        int count = 0;
        for (Link<T> curr = first; curr != null; curr = curr.getNext())
            count++;
        return count;
    }

    private boolean rangeCheck(int index){
        if (index >= 0 & index < size())
            return true;
        return false;
    }

    public void addFirst(T element) {
        if (element == null)
            return;
        first = new Link<T>(element, first);
    }

    public void add(T element) {
        if (element == null)
            return;
        Link<T> addition = new Link<T>(element);
        if (first == null) {
            first = addition;
            return;
        }
        Link<T> curr = first;
        while (curr.getNext() != null)
            curr = curr.getNext();
        curr.setNext(addition);
    }

    public void add(int index, T element) {
        if (element == null || !rangeCheck(index))
            return;
        Link<T> addition = new Link<T>(element);
        if (index == 0){
            addition.setNext(first);
            first = addition;
            return;
        }
        int i =0;
        Link<T> curr = first;
        while (i != index - 1){
            i++;
            curr = curr.getNext();
        }
        addition.setNext(curr.getNext());
        curr.setNext(addition);
    }

    public T set(int index, T element) {
        if (!rangeCheck(index) | element == null)
            return null;
        Link<T> addition = new Link<T>(element);
        T returnData;
        if (index == 0){
            returnData = first.getData();
            addition.setNext(first.getNext());
            first = addition;
            return returnData;
        }
        int i =0;
        Link<T> curr = first;
        while (i != index - 1){
            i++;
            curr = curr.getNext();
        }
        returnData = curr.getNext().getData();
        addition.setNext(curr.getNext().getNext());
        curr.setNext(addition);
        return returnData;
    }

    public T get(int index) {
        if (!rangeCheck(index))
            return null;
        int i =0;
        Link<T> curr = first;
        while (i != index){
            i++;
            curr = curr.getNext();
        }
        return curr.getData();
    }

    public boolean remove(T element) {
        if (element == null || !contains(element))
            return false;
        if (first.getData().equals(element)){
            first.setNext(first.getNext());
            return true;
        }
        Link<T> curr = first;
        while (!curr.getNext().getData().equals(element))
            curr = curr.getNext();
        curr.setNext(curr.getNext().getNext());
        return true;
    }

    @Override
    public T remove(int index) {
        if (!rangeCheck(index))
            throw new IllegalArgumentException("Illegal index");
        if (index == 0){
            T returnData = first.getData();
            first = first.getNext();
            return returnData;
        }
        index--;
        Link<T> curr = first;
        while (index!=0){
            curr = curr.getNext();
            index--;
        }
        T returnData = curr.getNext().getData();
        curr.setNext(curr.getNext().getNext());
        return returnData;
    }

    public boolean contains(T element) {
        if (element == null)
            return false;
        for (Link<T> curr = first; curr != null; curr = curr.getNext())
            if (curr.getData().equals(element))
                return true;
        return false;
    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        return false;
    }

    public String toString(){
        if (first == null)
            return "[]";
        return first.toString();
    }

    public boolean equals(Object other) {
        if (!(other instanceof LinkedList<?>) || ((LinkedList<?>) other).size() != size())
            return false;
        Iterator<T> iterator = iterator();
        Iterator<?> otherIterator = ((LinkedList<?>) other).iterator();
        while (iterator.hasNext())
            if (!iterator.next().equals(otherIterator.next()))
                return false;
        return true;
    }

    public void reverse(){
        LinkedList<T> rev = new LinkedList<>();
        for (Link<T> curr = first; curr != null; curr = curr.getNext())
            rev.addFirst(curr.getData());
        first = rev.first;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<>(first);
    }
}
