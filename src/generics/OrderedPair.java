package generics;

/**
 * Created by Bext on 17/01/2017.
 */
public class OrderedPair<K,V> implements ifacePair<K,V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
