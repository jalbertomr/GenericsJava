package generics;

import junit.framework.TestCase;

/**
 * Created by Bext on 18/01/2017.
 */
public class UtilTest extends TestCase {
    public void testCompare() throws Exception {
        Pair<String,Integer> p1 = new Pair<>("altura",12);
        Pair<String,Integer> p2 = new Pair<>("ancho", 34);
        boolean res = Util.compare( p1, p2);

        assertEquals(false,res);
    }

}