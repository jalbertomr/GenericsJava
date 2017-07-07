package generics;

/**
 * Created by Bext on 18/01/2017.
 */
public class Pair< K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {  //public void Pair(... el void le mete ruido cuando se llama el constructor
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
