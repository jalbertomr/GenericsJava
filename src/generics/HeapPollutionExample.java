package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bext on 24/01/2017.
 */
public class HeapPollutionExample {

    static class ArrayBuilder {
        static <T> void addToList(List<T> ListArg, T... elements){
            for ( T x : elements) {
                ListArg.add(x);
            }
        }
        static void faultyMethod(List<String>... l) {
            Object[] objectArray = l;
            objectArray[0] = Arrays.asList(42);
            //String s = l[0].get(0);
            //Error java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        }

    }

    public static void main(String[] args) {
        List<String> stringListA = new ArrayList<String>();
        List<String> stringListB = new ArrayList<String>();

        ArrayBuilder.addToList(stringListA, "Seven","eight","nine");
        ArrayBuilder.addToList(stringListB, "ten","eleven","twelve");
        List<List<String>> listOfStringLists = new ArrayList<List<String>>();
        ArrayBuilder.addToList(listOfStringLists, stringListA, stringListB);

        ArrayBuilder.faultyMethod( Arrays.asList("Hello!"), Arrays.asList("World!"));
    }
}
