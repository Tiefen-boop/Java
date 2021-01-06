public class BinarySearchTree<T> extends BinaryTree<T> {
    //fields
    private Comparator<T> comparator;

    //constructor
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> getComparator(){
        return comparator;
    }

    public void setComparator(Comparator<T> comparator){
        this.comparator = comparator;
        if (root!=null)
            ((BinarySearchTreeNode<T>)root).setComparator(comparator);
    }

    public void insert(T element) {
        if (element == null)
            throw new IllegalArgumentException("Null argument");
        if (root == null)
            root = new BinarySearchTreeNode<>(element, comparator);
        else
            root.insert(element);
    }

    public boolean equals(Object other) {
        if (!(other instanceof BinarySearchTree<?>))
            return false;
        if (root == null & ((BinarySearchTree<?>) other).root == null)
            return true;
        if (root != null & ((BinarySearchTree<?>) other).root != null) {
            return root.equals(((BinarySearchTree<?>) other).root);
        }
        return false;
    }
}
