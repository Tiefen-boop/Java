public class Link<T> {
    //fields
    private T data;
    private Link<T> next;

    //constructor
    public Link(T data, Link<T> next){
        this.data = data;
        this.next = next;
    }

    public Link(T data){
        this.data = data;
        this.next = null;
    }

    //methods
    public boolean setData(T data){
        if (data == null)
            return false;
        this.data = data;
        return true;
    }

    public boolean setNext(Link<T> next){
        this.next = next;
        return true;
    }

    public T getData(){
        return data;
    }

    public Link<T> getNext(){
        return next;
    }

    public boolean equals(Link<T> other){
        return data.equals(other.data);
    }

    public String toString(){
        return "[ " + toString(this) + " ]";
    }

    private String toString(Link<T> link){
        if (link.getNext() == null)
            return link.data.toString();
        return link.data.toString() + " -> " + toString(link.getNext());
    }
}
