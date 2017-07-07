package generics;

/**
 * Created by Bext on 18/01/2017.
 */
public class GenInhSubType {

    public static void someMethod(Number n) {
        System.out.println(n);
    }

    public void boxTest(GenericBox<Number> n){/*..*/}
/*            Number                Box<Number>
                 |                       +  No deciende
             Integer                Box<Integer>
                          Object
                            |
                Box<Number>     Box<Integer>

          Sample Collection hierarchy

                Collection<String>
                        |
                    List<String>
                        |
                 ArrayList<String>

    interface PayLoadList<E,P> extends List<E> {
      void setPayLoad(int index, P Val);
      ...
    }

    PayLoadList<String,String>
    PayLoadList<String,Integer>
    PayLoadList<String,Exception>

                                    Collection<String>
                                            |
                                        List<String>
                         ___________________|___________________________
                        |                   |                           |
    PayLoadList<String,String>  PayLoadList<String,Integer> PayLoadList<String,Exception>
*/


    public static void main(String... args){
        Object obj = new Object();
        Integer someInteger = new Integer(10);
        obj = someInteger;
        //someInteger = obj;  //incompatible types     // object

                                                       // Integer
        someMethod(new Integer(10));
        someMethod(new Double(10.1));

        GenericBox<Number> gBoxNumber = new GenericBox<Number>();
        gBoxNumber.set(new Integer(345));
        gBoxNumber.set(new Double(23.32));
    }
}
