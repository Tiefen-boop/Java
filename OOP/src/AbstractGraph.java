public abstract class AbstractGraph implements Graph{
    //fields
    final private int numberOfVertices;

    //constructor
    public AbstractGraph(int numberOfVertices){
        if (numberOfVertices <= 0)
            throw new IllegalArgumentException("non-positive number of vertices");
        this.numberOfVertices = numberOfVertices;
    }

    //copy
    protected void copy(Graph other){
        Iterator<Edge> iterator = other.edgeSet().iterator();
        while (iterator.hasNext()){
            Edge edge = iterator.next();
            addEdge(edge.getLeft(), edge.getRight());
        }
    }

    //methods
    protected boolean rangeCheck(int i, int j) {
        return 	i >= 0 && i < numberOfVertices() &&
                j >= 0 && j < numberOfVertices() &&
                i != j;
    }

    protected boolean rangeCheck(int i) {
        return 	i >= 0 && i < numberOfVertices();
    }

    @Override
    public int numberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return edgeSet().size();
    }

    @Override
    public int degree(int v) {
        if(!rangeCheck(v))
            throw new IllegalArgumentException();
        return neighborsOf(v).size();
    }

    @Override
    public Set<Integer> neighborsOf(int v) {
        if(!rangeCheck(v))
            throw new IllegalArgumentException();
        Set<Integer> adj = new SetAsLinkedList<>() ;
        for(int u = 0; u < numberOfVertices(); u = u+1)
            if(u != v && containsEdge(u,v))
                adj.add(u);
        return adj;
    }

    @Override
    public Set<Edge> edgeSet() {
        Set<Edge> edgeSet = new SetAsLinkedList<>() ;
        for(int i = 0; i < numberOfVertices; i++)
            for (int j = i+1 ; j < numberOfVertices; j++)
                if(containsEdge(i,j))
                    edgeSet.add(new Edge(i,j));
        return edgeSet;
    }

    public boolean equals(Object other){
        if (!(other instanceof Graph))
            return false;
        return numberOfVertices == ((Graph)other).numberOfVertices() && edgeSet().equals(((Graph)other).edgeSet());
    }

    public String toString() {
        return "G=([" + numberOfVertices + "], " + edgeSet() + ")";
    }

    abstract public void addEdge(int i, int j);
    abstract public void removeEdge(int i, int j);
    abstract public boolean containsEdge(int i, int j);
}