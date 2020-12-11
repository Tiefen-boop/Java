public class LinkedList<T> implements List<T> {
    //fields
    private Link<T> first;

    //constructors
    public LinkedList(){
        first = null;
    }

    public LinkedList(Link<T> first){
        this.first = first;
    }

    public LinkedList(LinkedList<T> linkedList){
        first = linkedList.first;
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
        Link<T> addition = new Link<T>(element, first);
        first = addition;
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
        if (!rangeCheck(index) | element == null)
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

    public boolean equals(LinkedList<T> other) {
        if (other == null || size() != other.size())
            return false;
        for (Link<T> curr = first, otherCurr = other.first; curr != null; curr = curr.getNext(), otherCurr = otherCurr.getNext())
            if (!curr.getData().equals(otherCurr.getData()))
                return false;
        return true;
    }

    public void reverse(){
        LinkedList<T> rev = new LinkedList<>();
        for (Link<T> curr = first; curr != null; curr = curr.getNext())
            rev.addFirst(curr.getData());
        first = rev.first;
    }
}
