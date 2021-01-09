public class HasEulerianCircleAlgorithm extends GraphAlgorithm{
    public HasEulerianCircleAlgorithm(Graph input) {
        super(input);
    }

    @Override
    public Object runAlgorithm() {
        ConnectivityAlgorithm a1 = new ConnectivityAlgorithm(input);
        EvenDegreesAlgorithm a2 = new EvenDegreesAlgorithm(input);
        return (Boolean) a1.runAlgorithm() & (Boolean) a2.runAlgorithm();
    }
}