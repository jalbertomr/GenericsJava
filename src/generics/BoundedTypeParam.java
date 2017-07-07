package generics;

/**
 * Created by Bext on 18/01/2017.
 */
public class BoundedTypeParam<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <U extends Number> void inspect(U u) {  //public <U extends Number & String> void inspect(U u) {  String debe ser interface
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String... args) {
        BoundedTypeParam<Integer> bdtBox = new BoundedTypeParam<>();
        bdtBox.setT( 123);
        bdtBox.inspect(12.23);

        BoundedTypeParam<Integer> bdtBox2 = new BoundedTypeParam<>();
        //bdtBox2.setT(123.23);  //Integer cannot be applied to double
        bdtBox2.setT(new Integer(100));
        //bdtBox2.inspect("OjoString");  // ...cannot be applied to given types. String infered Type does not conform to upper bound
        bdtBox2.inspect(new Double(23.453));
    }
}
