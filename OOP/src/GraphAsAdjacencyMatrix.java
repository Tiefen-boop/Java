public class GraphAsAdjacencyMatrix extends AbstractGraph{
    //fields
    private boolean[][] adjMatrix;

    //constructor
    public GraphAsAdjacencyMatrix(int numberOfVertices){
        super(numberOfVertices);
        adjMatrix = new boolean[numberOfVertices][numberOfVertices];
    }

    //copy constructor
    public GraphAsAdjacencyMatrix(Graph other){
        this(other.numberOfVertices());
        copy(other);
    }

    //methods
    @Override
    public void addEdge(int i, int j) {
        if (!rangeCheck(i, j))
            throw new IllegalArgumentException();
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    @Override
    public void removeEdge(int i, int j) {
        if (!rangeCheck(i, j))
            throw new IllegalArgumentException();
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    @Override
    public boolean containsEdge(int i, int j) {
        if (!rangeCheck(i, j))
            throw new IllegalArgumentException();
        return adjMatrix[j][i];
    }
}
