package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bext on 20/01/2017.
 */
public class WildCardSubTyping {

   void foo(List<?> list){
       fooHelper(list);
       //list.add(0, list.get(0));  //Wrong second argument type fount "?" required add(int, capture<?>) in List
                                        // cannot be applied to (int, capture<?>)
   }

   private <T> void fooHelper(List<T> list) {
       list.add( 0 , list.get(0));
   }

   public static void main(String... args){
      Number Num = new Integer(10);  //new Number(10); error is abstract
      Object obj = Num;

      List<Number> listNum = new ArrayList<>();
      //List<Object> listObj = listNum;  //incompatible types List<Object> List<Number>

      /*                    List<?>
                                |
                   List<Number>    List<Object>
      */

      List<? extends Number> list_ExtendsNum = new ArrayList<>();
      List<? extends Object> list_ExtendsObj = list_ExtendsNum;   //OK

       /*                           List<?>
                                       |
            List<? extends Number>           List<? extends Object>
                    |              \       /         |
            List<? extends Object>  \     /  List<? extends Number>
                    |                \   /            |
            List<Object>              \ /    List<Number>
        */
   }
}
