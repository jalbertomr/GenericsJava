package generics;

/**
 * Created by Bext on 18/01/2017.
 */
public class UseMethodDefInBound<T extends Integer> {
    private T t;

    public UseMethodDefInBound(T t) { this.t = t; }

    public boolean isEven() {
        return t.intValue() % 2 == 0;  //int value is a method defined in the Bound Integer
    }

    public static void main(String... args) {
        UseMethodDefInBound umdib = new UseMethodDefInBound(2);
        System.out.println(umdib.isEven());

        UseMethodDefInBound umdib2 = new UseMethodDefInBound(3);
        System.out.println(umdib2.isEven());
    }

}
