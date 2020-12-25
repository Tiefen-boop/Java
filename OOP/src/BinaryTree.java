public class BinaryTree<T> {
    //fields
    private BinaryTreeNode<T> root;

    //constructors
    public BinaryTree(){
        root = null;
    }

    //methods
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(T element){
        if (element == null)
            throw new IllegalArgumentException("Null argument");
        if (root == null)
            root = new BinaryTreeNode(element);
        else
            root.insert(element);
    }
    public void remove(T element){
        if (element == null)
            throw new IllegalArgumentException("Null argument");
        if (root != null)
            root.remove(element);
    }
    public boolean contains(T element) {
        if (element == null)
            throw new IllegalArgumentException("Null argument");
        if (root != null)
            return root.contains(element);
        return false;
    }
    public int height() {
        if (root != null)
            return root.height();
        return -1;
    }
    public int size() {
        if (root != null)
            return root.size();
        return 0;
    }
    public boolean equals(Object other) {
        if (!(other instanceof BinaryTree<?>))
            return false;
        if (root == null & ((BinaryTree<?>) other).root == null)
            return true;
        if (root != null & ((BinaryTree<?>) other).root != null)
            return root.equals(((BinaryTree<?>) other).root);
        return false;
    }
    public String toString(){
        if (root != null)
            return root.toString();
        return "";
    }
    /*
    public Iterator<T> iterator(){

    }
     */
}
