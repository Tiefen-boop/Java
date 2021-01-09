public class ConnectivityAlgorithm extends GraphAlgorithm{
    //constructor
    public ConnectivityAlgorithm(Graph input) {
        super(input);
    }

    @Override
    public Object runAlgorithm() {
        boolean[] visited = new boolean[input.numberOfVertices()];
        travel(0, visited);
        for (boolean visit : visited)
            if (!visit)
                return false;
        return true;
    }

    private void travel(int vertex, boolean[] visited){
        visited[vertex] = true;
        Iterator<Integer> iter = input.neighborsOf(vertex).iterator();
        while (iter.hasNext()){
            int neighbor = iter.next();
            if (!visited[neighbor])
                travel(neighbor, visited);
        }
    }
}
