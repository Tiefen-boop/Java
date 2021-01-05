import java.util.NoSuchElementException;

public class BinaryTreeInOrderIterator<T> implements Iterator<T> {
    //fields
    private Stack<BinaryTreeNode<T>> stack;

    //constructor
    public BinaryTreeInOrderIterator(BinaryTreeNode<T> root){
        stack = new StackAsLinkedList<BinaryTreeNode<T>>();
        prepareNext(root);
    }

    private void prepareNext(BinaryTreeNode<T> node) {
        while (node!=null){
            stack.push(node);
            node = node.left;
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
        BinaryTreeNode<T> node = stack.pop();
        prepareNext(node.right);
        return node.data;
    }
}
