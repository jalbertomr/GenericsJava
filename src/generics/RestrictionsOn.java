package generics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Bext on 24/01/2017.
 */
public class RestrictionsOn {

    //Cannot Create Instances of Type Parameters
    static <E> void appendError(List<E> list) {
        //E elem = new E();  //Type parameter E cannot be instantiated directly
        //list.add(elem);
    }

    static <E> void append( List<E> list, Class<E> cls) throws Exception {
        E elem = cls.newInstance();    //OK
        list.add(elem);
    }

    //Cannot Declare Static Fields Whose Types are Type Parameters
    //public class MovileDevice<T> {
    //    private static T os;      //inner classes cannot have static declarations
    //}

    //Cannot Use Casts or instanceof with Parameterized Types
    /*
    static <E> void rtti( List<E> list) {
        if (list instanceof ArrayList<Integer>) {  //Illegal generic type of instanceof
            //..
        }
    }
    */
    //The set of parameterized types passed to the rtti method is
    //S = {ArrayList<Integer>, ArrayList<String>, ArrayList<Character>,...}

    /*The runtime does not keep track of type parameters, so it cannot tell the difference between
     an ArrayList<Integer> and an ArrayList<String>. The most you can do is to use an unbounded
     wildcard to verify that the list is an ArrayList:
    */
    static<E> void rttiAllowed( List<E> list) {
        if (list instanceof ArrayList<?>) {// OK instanceof requires a reifiable type}
            //...
        }
    }

    //Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
    class Example {
        /*
        public void print(Set<Integer> intSet) {}  //Error print(Set<Integer> clashes with print(Set<String>)
        public void print(Set<String> strSet) {}   // both methods have same erasure
        */
    }

    //Cannot Create, Catch, or Throw Objects of Parameterized Types

    //Error generic class may not extends java.lang.Throwable
    //class MathException<T> extends Exception { /*...*/ }           //indirectrlly
    //class QueueFullException<T> extends Throwable { /*...*/ }      //directly

    //A method cannot catch an instance of a type parameter:
    /*
    static <T extends Exception, J> void execute( List<J> jobs) {
       try {
         for( J job : jobs) {
             //... };
       } catch (T t) {       //Error cannot catch type parameters
          //...
       }
    }
    */
    //You can, however, use a type parameter in a throws clause:
    class Parser<T extends Throwable> {
        void parse(File file) throws T {  //OK
            /*...*/
        }
    }


    public static void main(String[] args) {

        //Cannot Instantiate Generic Types with Primitive Types
        //Pair<int, char> p = new Pair<>( 8, 'd');   //compile time error
        Pair<Integer,Character> p = new Pair<>( 8 , 'd');  //OK
        //java autoboxes to
        //Pair<Integer, Character> p = new Pair<>(Integer.valueOf(8), new Character('a'));

        //Cannot Create Instances of Type Parameters
        List<String> list = new ArrayList<>();
        try {
            append(list, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Cannot Declare Static Fields Whose Types are Type Parameters
        //MovileDevice<Smartphone> phone = new MovileDevice<>();
        //MovileDevice<Pager> pager = new MovileDevice<>();
        //MovileDevice<Pc> pc = new MovileDevice<>();
        //Static field os is shared, so what is the actual type of os, it cannnot be Smartphone,Pager,
        //Pc at the same time. cannot create static fields of type parameters

        //Cannot Use Casts or instanceof with Parameterized Types
        //Typically, you cannot cast to a parameterized type unless it is parameterized by unbounded wildcards. For example:
        List<Integer> li = new ArrayList<>();
        //List<Number> ln = li;                 //incompatible types
        //List<Number> ls = (List<Number>) li;  //cannot cast List<Integer> to List<Number>

        //However, in some cases the compiler knows that a type parameter is always valid and allows the cast. For example:
        List<String> ls = new ArrayList<>();
        //ArrayList<String> lAL = ls;             //incompatible types List, ArrayList
        ArrayList<String> lALCasted = (ArrayList)ls;  //OK

        //Cannot Create Arrays of Parameterized Types
        //List<Integer>[] arrayOfList = new List<Integer>[2];  //generic array creation

        //The following code illustrates what happens when different types are inserted into an array:
        Object[] arrObj = new String[2];
        arrObj[0] = "Hello";
        arrObj[1] = 34;         //An ArrayStoreException

        //If you try the same thing with a generic list, there would be a problem:
        /*
        Object[] arrObj2 = new List<String>[2];   //compiler error, but pretend it's allowed
        arrObj2[0] = new ArrayList<String>();     //OK
        arrObj2[1] = new ArrayList<Integer>();    //An ArrayStoreException should be thrown,
                                                  // but the runtime can't detect it.
        */
        //If arrays of parameterized lists were allowed, the previous code would fail to throw the desired ArrayStoreException.

        //Cannot Create, Catch, or Throw Objects of Parameterized Types




        //Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type

    }
}
