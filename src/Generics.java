import sun.net.www.content.text.Generic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

//Multiple Bounds  Se declara aqui por que la interface no se puede declarar dentro de class
class A{}
interface B{}
interface C{}
class D <T extends A & B & C> {}
//class E <T extends B & C & A> {}  error en el orden de la declaracion

class SimpleBox {
    private Object obj;

    public SimpleBox(Object obj) { this.obj = obj; }

    public Object getObj() { return obj; }
    public void setObj(Object obj) { this.obj = obj; }
    public String description() {
        return obj.getClass().toString();
    }
    public String toString() {
        return description() + " " + obj.toString();
    }
}

//Box Generics
class Box<T> {
    private T t;

    public void set(T t){ this.t = t;}
    public T get(){ return t;}

    public <U extends Number> void inspect(U u) {     //Bounded Type Parameter
        System.out.println("T :" + t);
        System.out.println("U :" + u);
    }

    public void boxTest( Box<Number> n ) {
        System.out.println("boxTest(Box<Number> n : " + n );
    }
}

//metodo que usa List sin generics, Debe hacer casting al recuperar elemento de la Lista al asignarlo
class SinGenerics {
    String s;

    public void metodo() {
        List list = new ArrayList();
        list.add("Hello Sin Generics");
        try {
            s = (String) list.get(0);
            System.out.println("Data sin generics:" + s);
        } catch (Exception e) {
            System.err.println("Error datos en lista " + e);
        }
    }
}

//metodo que usa List sin generics, No hace casting al recuperar elemento y desde el codigo se controla
//lost types que tiene la List
class ConGenerics {
    private String s;

    public void metodo() {
        List<String> list = new ArrayList<String>();
        list.add("Hello con Generics");
        s = list.get(0);
        System.out.println("Data con generics : " + s);
    }
}

class GenericBox<T> {  //T stands for Type
    private T t;

    public GenericBox() {}
    public GenericBox(T t) { this.t = t; }

    public T getT() { return t; }
    public void setT(T t) { this.t = t; }
    public String description(){
        return t.getClass().toString();
    }
    public String toString() {
        return description() + " " + t.toString();
    }

    public <U extends Number> void inspect(U u) {                  //Bounded Type Parameter
        System.out.println("T :" + t);
        System.out.println("U :" + u);
    }

    public void boxTest( GenericBox<Number> n ) {
        System.out.println("boxTest(Box<Number> n : " + n );
    }

}

class GenericBox2Types<T,R> {
    private T t;
    private R r;

    public GenericBox2Types(T t, R r) {
        this.t = t;
        this.r = r;
    }

    public T getT() { return t; }
    public R getR() { return r; }
    public void setT(T t) { this.t = t; }
    public void setR(R r) { this.r = r; }

    public String description(){
        String desc = new String(" Descripcion: ");
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field f : fields){
            desc = desc.concat(" " + f.getType().toString() + " " + f.toString());
        }
        return desc;
    }

    @Override
    public String toString() {
        return "GenericBox{" +
                "t=" + t +
                ", r=" + r +
                '}';
    }
}

interface Pair<K,V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pair<K,V>{
    K key;
    V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key;}
    public V getValue() { return value;}

    @Override
    public String toString() {
        return "OrderedPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class Util { //Multiple Type Parameters
    static public <K, V> boolean compare( PairGM<K, V> p1, PairGM<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p2.getValue().equals(p2.getValue());
    }
}

class PairGM<K, V> { //Multiple Type Parameters
    private K key;
    private V value;

    public PairGM(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
}
/*
interface Comparable<T> {
    public int compareTo(T o);
}

public  <T extends Comparable<T>> int countGreaterThan(T[] array, T elem) {
        int count = 0;
        for (T e: array) {
            if (e.compareTo(elem) > 0)
                count++;
        }
        return count;
    }
}
*/
/*  Generic Methods and bounded type paramenters
public static <T>  T intentaInstanciarT(T[] array, T elem) {
    T m0;             //Variable 'm' might not be initialized
    T m = elem;       //OK para return
    T m1 = new T();  // type parameter T cannot be inistantiated directly
    T m2 = new m2<T>(); //cannot resolve symbol m2

    return m;
}*/

/*
public static <T> int countGreaterThan(T[] array, T elem) {
    int count = 0;
    for (T e: array) {
        if (e > elem) count++;     //Operator '<' cannot be applied to 'T','T'
    }
    return count;
}
*/


/**
 * Created by Bext on 12/12/2016.
 * Type namimng convertion
 * E Element
 * K key
 * N number
 * V value
 * T type
 * S,U,V etc types
 */
public class Generics {

    static class StaticClass {
        public void metodo() {
            System.out.println("clase static");
        }
    }

    public static void main(String... args) {

        Generics myGenerics = new Generics();

        System.out.println("metodo sin generics");
        SinGenerics sinG = new SinGenerics();
        sinG.metodo();

        System.out.println("metodo con generics");
        ConGenerics conG = new ConGenerics();
        conG.metodo();

        StaticClass sc = new StaticClass();
        sc.metodo();

        //Box
        SimpleBox mySimpleBox = new SimpleBox("SimpleBox string data");
        System.out.println("SimpleBox :" + mySimpleBox.toString());

        SimpleBox mySimpleBox2 = new SimpleBox(123);
        System.out.println("SimpleBox :" + mySimpleBox2.toString());

        //Generic Box
        GenericBox<String> myGenericBoxString = new GenericBox<>("GenericBox string data");
        System.out.println( "GenericBox Integer" + myGenericBoxString.toString());

        GenericBox<Integer> myGenericBoxInteger = new GenericBox<>(12345);
        System.out.println( "GenericBox String" + myGenericBoxInteger.toString());

        System.out.println("Multiple Type Parameters");
        GenericBox2Types<String,Integer> myGenBoxStrInt = new GenericBox2Types<>("StringData", 1234);
        System.out.println( "GenericBox2Types String Integer" + myGenBoxStrInt.description());

        GenericBox2Types<Integer,String> myGenBoxIntStr = new GenericBox2Types<>( 12345, "StringData");
        System.out.println("GenericBox2Types Integer String"  + myGenBoxIntStr.description());

        Pair<String,Integer> p1 = new OrderedPair<String,Integer>("Even", 8);
        System.out.println("OrderedPair : " + p1.toString());

        Pair<String,Integer> p11 = new OrderedPair<>("Even", 8);
        System.out.println("OrderedPair : " + p11.toString());

        Pair<String,String> p2 = new OrderedPair<>("Hola","odd");
        System.out.println("OrderedPair : " + p2.toString());

        System.out.println("Parametrized Types :ifacePair<String, GenericBox<Integer>> p22 = new OrderedPair<>(\"Hello\", new GenericBox<>(1234));");
        Pair<String, GenericBox<Integer>> p22 = new OrderedPair<>("Hello", new GenericBox<>(1234));
        System.out.println("OrderedPair : " + p22.toString());

        //Raw Type
        System.out.println("Raw Type");

        GenericBox rawBox = new GenericBox();

        GenericBox<Number> box = new GenericBox<>();
        GenericBox<Integer> intBox = new GenericBox<Integer>();
        box.setT( new Integer(23));
        box.setT( new Double(34.12));
        intBox.setT( new Integer(56));
        box.boxTest( box );
        //box.boxTest( intBox);


        // GenericBox(Object) in GenericBox cannot be applied to (), para evitar este mensaje se
        // crea constructor public GenericBox(){}
        GenericBox inrawBox = new GenericBox();

        GenericBox<String> stringedGenericBox = new GenericBox<>();
        inrawBox = stringedGenericBox;    //OK

        GenericBox inrawBox2 = new GenericBox();
        GenericBox<Integer> integerGenericBox = inrawBox2;

        System.out.println("Generic Methods");
        //Generic Methods
        PairGM<Integer,String> pgm1 = new PairGM(1, "Apple");
        PairGM<Integer,String> pgm2 = new PairGM(2, "pear");
        boolean same = Util.<Integer,String>compare(pgm1,pgm2);
        boolean same2 = Util.compare(pgm1,pgm2);

        //Bounded Type Parameter
        System.out.println("Bounded Type Parameter public <U extends Number> void inspect(U u){...");
        Box<Integer> integerBox = new Box<>();
        integerBox.set(new Integer(10));
        integerBox.inspect(123);
        integerBox.inspect(123.43);
        //integerBox.inspect("Some text");  //inspect(U) in Box cannot be applied to (java.lang.String)

        Object someObject = new Object();
        Integer anInteger = new Integer(123);
        someObject = anInteger;

        //Multiple Bounds
        System.out.println("Multiple Bounds");
        System.out.println("class A{}");
        System.out.println("interface B{}");
        System.out.println("interface C{}");
        System.out.println("class D <T extends A & B & C> {}");
        System.out.println("class D <T extends B & A & C> { /* ... */ }  // compile-time error");
    }
}

