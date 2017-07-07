package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bext on 17/01/2017.
 */


public class WhyUseGenerics {

    public static void main(String... args){
        //List list = new List();  //List is abstract canot be instantiated
        List list = new ArrayList();
        list.add("Hello");
        //String s = list.get(0);  //incompatible types required: String found: Object
        String s = (String) list.get(0);  //Casting

        List <String>listB = new ArrayList<String>();
        listB.add("10");
        String s2 = listB.get(0);   //cast not required and checked at compile time
    }
}
