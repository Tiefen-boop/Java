public class BinaryTreeNode<T> {
    //fields
    protected T data;
    protected BinaryTreeNode<T> left;
    protected BinaryTreeNode<T> right;

    //constructors
    public BinaryTreeNode(T data) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        this.data = data;
        left = null;
        right = null;
    }

    //methods
    public T getData(){
        return data;
    }

    public BinaryTreeNode<T> getLeft(){
        return left;
    }

    public BinaryTreeNode<T> getRight(){
        return right;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setLeft(BinaryTreeNode<T> left){
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right){
        this.right = right;
    }

    public void insert(T element) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        if (Math.random() < 0.5)
            if (left == null)
                left = new BinaryTreeNode<T>(element);
            else
                left.insert(element);
        else
            if (right == null)
                right = new BinaryTreeNode<T>(element);
            else
                right.insert(element);
    }

    public boolean remove(T element) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        if (data.equals(element)) {
            if (left != null) {
                setData(left.getData());
                left.remove(getData());
            }
            else if (right != null) {
                setData(right.getData());
                right.remove(getData());
            }
            else {
                data = null;
                return true;
            }
        }
        else if (left != null && left.remove(element)) {
            if (left.getData() == null)
                left = null;
            return true;
        }
        else if (right != null && right.remove(element)) {
            if (right.getData() == null)
                right = null;
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        if (data.equals(element))
            return true;
        return left != null && left.contains(element) || right != null && right.contains(element);
    }

    public int height() {
        int heightR = -1, heightL = -1;
        if (left != null)
            heightL = left.height();
        if (right != null)
            heightR = right.height();
        return Math.max(heightL, heightR) + 1;
    }

    public int size() {
        int sizeR = 0, sizeL = 0;
        if (left != null)
            sizeL = left.size();
        if (right != null)
            sizeR = right.size();
        return sizeL + sizeR + 1;
    }

    public boolean equals(Object other){
        if (!(other instanceof BinaryTreeNode<?>))
            return false;
        boolean result = true;
        if (!data.equals(((BinaryTreeNode<?>) other).data))
            result = false;
        if (result) //checking if left = other.left
            if (left != null)
                result = left.equals(((BinaryTreeNode<?>) other).left);
            else if (((BinaryTreeNode<?>) other).left != null)
                result = false;
        if (result) //checking if right = other.right
            if (right != null)
                result = right.equals(((BinaryTreeNode<?>) other).right);
            else if (((BinaryTreeNode<?>) other).right != null)
                result = false;
        return result;
    }

    public String toString() {
        return toString("") + "\n";
    }

    protected String toString(String depth) {
        String ans = "";
        if (right != null)
            ans = ans + right.toString(depth + "  ") + "\n";
        ans = ans + depth + data;
        if (left != null)
            ans = ans + "\n" + left.toString(depth + "  ");
        return ans;
    }
}
