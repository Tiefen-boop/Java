public class Record<T> {
    //fields
    private String key;
    private T value;

    //constructors
    public Record(String key, T value){
        this.key = key;
        this.value = value;
    }

    public Record(String key){
        this.key = key;
        value = null;
    }

    public Record(){
        this.key = null;
        value = null;
    }

    //methods
    public boolean setKey(String key){
        if (key == null)
            return false;
        this.key = key;
        return true;
    }

    public boolean setValue(T value){
        this.value = value;
        return true;
    }

    public String getKey(){
        return key;
    }

    public T getValue(){
        return value;
    }

    public String toString(){
        return "[ " + key + " , " + value + " ]";
    }

    public boolean equals(Record<T> other){
        return this.key.equals(other.key) && this.value.equals(other.value);
    }
}
