package generics;

import java.util.Arrays;
import java.util.List;

/**    UpperBound
 *     List<? extends Number>        Number
 *                                      |
 *                             Integer     Double
 */
public class UpperBoundedWildCard {

    //public static <U extends Number> double sumOfList( List<U> list){  //tambien compila
    public static double sumOfList( List<? extends Number> list){
        double s = 0.0;
        for ( Number elem : list) {
            s += elem.doubleValue();
        }
        return s;
    }

    public static void main(String... args) {
        List<Integer> listOfInt = Arrays.asList(10,20,30,40);
        /*
          Si en la funcion sumnOfList( List<Number> list) se define asi, al llamar sumOfList(listOfInt) dara error
          sumOfList(java.util.List<java.lang.Number> cannot be applied to (java.util.List<java.lang.Integer>
         */
        System.out.println( "suma : " + sumOfList(listOfInt));

        List<Double> listOfDouble = Arrays.asList(12.23,53.43,54.23);
        System.out.println( "suma : " + sumOfList(listOfDouble));
    }
}
