public class EulerianCirclePathAlgorithm extends GraphAlgorithm{
    private Graph dummy;
    private Stack<Integer> stack;
    private LinkedList<Integer> path;

    public EulerianCirclePathAlgorithm(Graph input) {
        super(input);
        dummy = null;
        stack = null;
        path = null;
    }

    @Override
    public Object runAlgorithm() {
        HasEulerianCircleAlgorithm hasEulerianCircleAlgorithm = new HasEulerianCircleAlgorithm(input);
        if (!(Boolean)hasEulerianCircleAlgorithm.runAlgorithm())
            return null;
        dummy = new GraphAsAdjacencyMatrix(input);
        path = new LinkedList<>();
        stack = new StackAsLinkedList<>();
        stack.push(0);
        buildPath(0);
        String ans = "< ";
        Iterator<Integer> iterator = path.iterator();
        while (iterator.hasNext())
            ans = ans + iterator.next() + ", ";
        dummy = null;
        stack = null;
        path = null;
        ans = ans.substring(0, ans.length()-2) + ">";
        return ans;
    }

    private void buildPath(int vertex){
        if (dummy.neighborsOf(vertex).size() == 0){
            path.addFirst(stack.pop());
            if (!stack.isEmpty())
                buildPath(stack.peek());
            return;
        }
        Iterator<Integer> iterator = dummy.neighborsOf(vertex).iterator();
        int neighbor = iterator.next();
        dummy.removeEdge(vertex, neighbor);
        stack.push(neighbor);
        buildPath(neighbor);
    }
}
