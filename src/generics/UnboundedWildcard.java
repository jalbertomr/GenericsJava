package generics;

import java.util.Arrays;
import java.util.List;

/**
 * List<?> is a list of unknown type
 * Use functionality provided by Class Object
 * when use methods in the generic class than don't depend of the Type Parameter
 * for example: List.size or List.clear
 * Class<?> is so often used because most of the methods of Class<T> do not depend on T
 *
 * List<Object> can be inserted an Object or any subtype of Object
 * List<?> only can be inserted null
 */
public class UnboundedWildcard {

    // List<Object>
    public static void printListObject(List<Object> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    //  List<?> unboundedwildcard
    public static void printList(List<?> list) {
        for (Object elem: list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    //  Class<?>
    public static void printClass(Class<?> parClass) {
        System.out.println( parClass.getName());
    }

    public static void main(String[] args) {
       List<Integer> listInt = Arrays.asList(1,2,3);
       List<String> listString = Arrays.asList("uno","dos","tres");

       //printListObject(listInt);
       //Error  printListObject(List<Object>) cannot be applied to List<Integer>
       //incompatible types: List<Integer> cannot be converted to List<Object>
       //printListObject(listString);
       //Error  printList(List<Object>) cannot be applied to List<String>
       //incompatible types: List<String> cannot be converted to List<Object>

       printList(listInt);
       printList(listString);

       printClass(listInt.getClass());
       printClass(listString.getClass());
    }
}
