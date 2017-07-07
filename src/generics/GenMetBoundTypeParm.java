package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bext on 18/01/2017.
 */
public class GenMetBoundTypeParm {

    public static Integer countGreaterThanInteger(Integer[] arrInt, Integer elem) {
        int count = 0;

        for (Integer i : arrInt) {
            if (i > elem){
                ++count;
            }
        }
        return count;
    }

    /*
    public static <T>  int countGreatherThan(T[] arrT, T elem) {
        int count = 0;

        for ( T e : arrT){
            if ( elem > e ){   // ">" only applies to primitive types short, int, long, double, float, byte, char
                ++count;
            }
        }
        return count;
    }
*/

    public static <T extends Comparable<T>> int countGreatherThan(T[] arrT, T elem) {
        int count = 0;

        for ( T e : arrT) {
            if ( e.comparteTo(elem) > 0 ) {
                ++count;
            }
        }
        return count;
    }

 /*   public <T> int compareTo(T o) {
        return this.hashCode() - o.hashCode();
    }
*/

    public static void main(String... args) {
        Integer[] arrInt = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(countGreaterThanInteger(arrInt, 2));

        String[] arrString = new String[]{"uno","dos","tres","cuatro","cinco"};
        String str = new String("dos");
        //List arrString2 = new ArrayList<String>[5];
        //System.out.println(countGreatherThan( arrString,str));
    }
}
