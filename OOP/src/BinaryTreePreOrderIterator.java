import java.util.NoSuchElementException;

public class BinaryTreePreOrderIterator<T> implements Iterator<T> {
    //fields
    private Stack<BinaryTreeNode<T>> stack;

    //constructor
    public BinaryTreePreOrderIterator(BinaryTreeNode<T> root){
        stack = new StackAsLinkedList<BinaryTreeNode<T>>();
        stack.push(root);
    }

    private void prepareNext(BinaryTreeNode<T> node) {
        if (node.right!=null)
            stack.push(node.right);
        if (node.left!=null)
            stack.push(node.left);
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
        BinaryTreeNode<T> node = stack.pop();
        prepareNext(node);
        return node.data;
    }
}
