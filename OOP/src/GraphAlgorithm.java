abstract public class GraphAlgorithm {

    protected Graph input ;

    public GraphAlgorithm(Graph input) {
        this.input = input ;
    }

    abstract public Object runAlgorithm() ;
}