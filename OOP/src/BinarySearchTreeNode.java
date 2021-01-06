public class BinarySearchTreeNode<T> extends BinaryTreeNode<T> {
    //fields
    private Comparator<T> comparator;

    //constructor
    public BinarySearchTreeNode(T data, Comparator<T> comparator) {
        super(data);
        this.comparator = comparator;
    }

    //methods
    public void insert(T element) {
        if (comparator.compare(element, data) > 0){
            if (right != null)
                right.insert(element);
            else
                right = new BinarySearchTreeNode<>(element, comparator);
        }
        else if (comparator.compare(element, data) < 0){
            if (left != null)
                left.insert(element);
            else
                left = new BinarySearchTreeNode<>(element, comparator);
        }
    }

    public BinaryTreeNode<T> remove(T toRemove) {
        if (data.equals(toRemove)){
            if (left == null | right == null){
                if (left == null)
                    return right;
                return left;
            }
            else {
                data = findMax(left);
                left = left.remove(data);
            }
        }
        else if (comparator.compare(toRemove, data) > 0)
            if (right != null)
                right = right.remove(toRemove);
        else
            if (left != null)
                left = left.remove(toRemove);
        return this;
    }

    private T findMin(BinaryTreeNode<T> node){
        if (node.left == null)
            return data;
        return findMin(node.left);
    }

    private T findMax(BinaryTreeNode<T> node){
        if (node.right == null)
            return data;
        return findMax(node.right);
    }

    public boolean contains(T element) {
        if (data.equals(element))
            return true;
        if (comparator.compare(element, data) > 0) {
            if (right == null)
                return false;
            return right.contains(element);
        }
        if (left == null)
            return false;
        return left.contains(element);
    }

    public boolean equals(Object other) {
        if (!(other instanceof BinaryTreeNode<?>))
            return false;
        if (!data.equals(((BinaryTreeNode<?>) other).data))
            return false;
        boolean result = true;
        if (left != null)
            result = left.equals(((BinarySearchTreeNode<?>) other).left);
        else
            result = ((BinarySearchTreeNode<?>) other).left == null;
        if (result) //checking if right side needs to be checked
            if (right != null)
                result = right.equals(((BinaryTreeNode<?>) other).right);
            else
                result = ((BinarySearchTreeNode<?>) other).right == null;
        return result;
    }

    public Comparator<T> getComparator(){
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
        if (left!=null)
            ((BinarySearchTreeNode<T>)left).setComparator(comparator);
        if (right!=null)
            ((BinarySearchTreeNode<T>)right).setComparator(comparator);
    }
}