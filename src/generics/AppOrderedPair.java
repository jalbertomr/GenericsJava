package generics;

/**
 * Created by Bext on 17/01/2017.
 */
public class AppOrderedPair {

    OrderedPair<String,Integer> p1 = new OrderedPair<String,Integer>("nivel",2);
    OrderedPair<String,String> p2 = new OrderedPair<String,String>("color","rojo");

    OrderedPair<String,Integer> p3 = new OrderedPair<>("par", 8);
    OrderedPair<String,String> p4 = new OrderedPair<>("Idioma","Ingles");

    GenericBox<Integer> gIntegerBox = new GenericBox<>(34);
    OrderedPair<String, GenericBox<Integer>> p5 = new OrderedPair<>("GenericBoxInteger", new GenericBox<Integer>(54));
}
