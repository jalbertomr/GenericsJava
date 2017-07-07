package generics;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Bext on 19/01/2017.
 */
public class TypeInference {

    public static <T,E> E pick(T par1, E par2){
        System.out.println(par1.getClass().getName());
        System.out.println(par2.getClass().getName());
        return par2;
    }

    public static void main(String... args) {
        Serializable s = pick("parString", new ArrayList<String>());
    }
}
