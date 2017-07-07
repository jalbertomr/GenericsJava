package generics;

/**
 * Created by Bext on 17/01/2017.
 */
public class GenericBox<T> {
    private T t;

    public GenericBox(){};
    public GenericBox(T t) {
        this.t = t;
    }

    public void set(T t) { this.t =  t;}
    public T get() {return t;}
}
