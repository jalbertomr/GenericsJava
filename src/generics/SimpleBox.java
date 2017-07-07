package generics;

/**
 * Created by Bext on 17/01/2017.
 */
public class SimpleBox {
    private Object obj;

    public SimpleBox(){};
    public SimpleBox(Object obj) {
        this.obj = obj;
    }

    public void set(Object obj) {this.obj = obj;}
    public Object get() {return this.obj;}
}
