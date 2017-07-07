package generics;

/**
 * Created by Bext on 18/01/2017.
 */
public class Util< K, V> {
    public static< K, V> boolean compare(Pair< K, V> p1, Pair< K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}
