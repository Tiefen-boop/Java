import java.util.NoSuchElementException;

public class BinaryTreePostOrderIterator<T> implements Iterator<T> {
    //fields
    private Stack<BinaryTreeNode<T>> stack;

    //constructor
    public BinaryTreePostOrderIterator(BinaryTreeNode<T> root){
        stack = new StackAsLinkedList<BinaryTreeNode<T>>();
        prepareStack(root);
    }

    private void prepareStack(BinaryTreeNode<T> root) {
        while (root!=null) {
            stack.push(root);
            if (root.right != null)
                prepareStack(root.right);
            root = root.left;
        }
    }

    //methods

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (stack.isEmpty())
            throw new NoSuchElementException();
        return stack.pop().data;
    }
}
