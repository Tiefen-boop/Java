//import java.util.Iterator;

public class SetOperations {

    //A is subset of B
    public static <T> boolean subset(Set<T> setA, Set<T> setB) {
        Iterator<T> iterB = setB.iterator();
        while (iterB.hasNext()){
            if (!setA.contains(iterB.next()))
                return false;
        }
        return true;
    }

    //Returns A union B
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> union = new SetAsDynamicArray<>();
        Iterator<T> iterA = setA.iterator();
        Iterator<T> iterB = setB.iterator();
        while (iterA.hasNext()){
            union.add(iterA.next());
        }
        while (iterB.hasNext()){
            union.add(iterB.next());
        }
        return union;
    }

    //Returns A intersection B
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> intersection = new SetAsDynamicArray<>();
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()){
            T element = iterA.next();
            if (setB.contains(element))
                intersection.add(element);
        }
        return intersection;
    }

    //Returns A subtraction B
    public static <T> Set<T> subtraction(Set<T> setA, Set<T> setB) {
        Set<T> subtraction = new SetAsDynamicArray<>();
        Iterator<T> iterSetA = setA.iterator();
        while (iterSetA.hasNext()){
            T element = iterSetA.next();
            if (!setB.contains(element))
                subtraction.add(element);
        }
        return subtraction;
    }
}