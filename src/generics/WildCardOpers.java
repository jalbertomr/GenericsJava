package generics;

import java.util.List;

/**
 * Created by Bext on 27/03/2017.
 */
public class WildCardOpers {

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (int i = 0; i < src.size(); i++) {
            dest.set( i, src.get(i) );
        }
    }
}
