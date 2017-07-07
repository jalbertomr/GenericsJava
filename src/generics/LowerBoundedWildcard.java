package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**   LowerBound  <? super A>
 *      List<? super Integer>         Object
 *                                      |
 *                                    Number
  *                                     |
  *                                   Integer
*/


public class LowerBoundedWildcard {

    //this work with List<Integer>, List<Number> , List<Object>
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    //only prints de list
    //printList(List<Object> list) {  does not accept List<Integer>, List<Number> so ..
    public static void printList(List<? extends Object> list) {
        System.out.print(list.get(0).getClass().getName() + " ");
        for( Object elem: list) {
           System.out.print(elem.toString() + " ");
        }
        System.out.println();
    }

    public static void main(String... args) {
        List<Integer> listInt = new ArrayList<>();
        List<Number> listNum = new ArrayList<>();
        List<Object> listObj = new ArrayList<>();

        addNumbers(listInt);
        addNumbers(listNum);
        addNumbers(listObj);

        printList(listInt);
        printList(listNum);
        printList(listObj);
    }
}
