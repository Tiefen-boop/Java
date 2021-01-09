public class EvenDegreesAlgorithm extends GraphAlgorithm{
    //constructor
    public EvenDegreesAlgorithm(Graph input) {
        super(input);
    }

    @Override
    public Object runAlgorithm() {
        for (int i = 0; i < input.numberOfVertices(); i++)
            if (input.neighborsOf(i).size() % 2 != 0)
                return false;
        return true;
    }
}