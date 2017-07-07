package generics;

/**
 * Created by Bext on 18/01/2017.
 */
public class AppUtil {

    public static void main(String... args) {
        Pair<String,Integer> p1 = new Pair<>("altura",12);
        Pair<String,Integer> p2 = new Pair<>("ancho", 34);
        boolean res = Util.compare( p1, p2);
        System.out.println(res);
    }
}
