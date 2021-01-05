import java.util.NoSuchElementException;

public class BinaryTreeBFSIterator<T> implements Iterator<T> {
    //fields
    private Queue<BinaryTreeNode<T>> queue;

    //constructor
    public BinaryTreeBFSIterator(BinaryTreeNode<T> root){
        queue = new QueueAsDynamicArray<BinaryTreeNode<T>>();
        queue.enqueue(root);
    }

    private void prepareNext(BinaryTreeNode<T> node) {
        if (node.left!=null)
            queue.enqueue(node.left);
        if (node.right!=null)
            queue.enqueue(node.right);
    }

    //methods

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (queue.isEmpty())
            throw new NoSuchElementException();
        BinaryTreeNode<T> node = queue.dequeue();
        prepareNext(node);
        return node.data;
    }
}
