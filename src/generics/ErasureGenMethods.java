package generics;

import java.util.List;

/**
 * Created by Bext on 23/01/2017.
 */
public class ErasureGenMethods {

    //Count occurences of elem in an array
    public static <T> int count(T[] anArray, T elem){
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }

    //Because T is unbounded java replace it with Object
    public static <Object> int countReplaced(Object[] anArray, Object elem) {
        int cnt = 0;
        for (Object e: anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }

    class Shape { /*...*/}
    class Circle extends Shape {/*...*/}
    class Rectangle extends Shape {/*...*/}

    //You can write a generic method to draw different shapes
    public static <T extends Shape> void draw(T shape) {/*...*/}

    //Java compiler replaces T with shape
    public static <Shape> void drawReplaces(Shape shape) {/*...*/}
}
