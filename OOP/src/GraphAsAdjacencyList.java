public class GraphAsAdjacencyList extends AbstractGraph{
    //fields
    private List<List<Integer>> adjList;

    //constructor
    public GraphAsAdjacencyList(int numberOfVertices){
        super(numberOfVertices);
        adjList = new LinkedList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    //copy constructor
    public GraphAsAdjacencyList(Graph other){
        this(other.numberOfVertices());
        copy(other);
    }

    @Override
    public void addEdge(int i, int j) {
        if (!rangeCheck(i, j))
            throw new IllegalArgumentException();
        if (i > j){
            int tmp = i;
            i = j;
            j = tmp;
        }
        if (!containsEdge(i, j))
            adjList.get(i).add(j);
    }

    @Override
    public void removeEdge(int i, int j) {
        if (!rangeCheck(i, j))
            throw new IllegalArgumentException();
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        if (containsEdge(i, j)) {
            adjList.get(i).remove((Integer) j);
        }
    }

    @Override
    public boolean containsEdge(int i, int j) {
        if (!rangeCheck(i, j))
            throw new IllegalArgumentException();
        if (i > j){
            int tmp = i;
            i = j;
            j = tmp;
        }
        return adjList.get(i).contains(j);
    }
}
