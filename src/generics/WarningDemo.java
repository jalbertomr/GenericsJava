package generics;

import static generics.WarningDemo.createBox;

/**
 * Created by Bext on 18/01/2017.
 *
 * No genera el warning unchecked convertion
 */
public class WarningDemo {
    public static void main(String... args){
        GenericBox<Integer> gBoxInteger;
        gBoxInteger = createBox();
    }

    static GenericBox createBox(){
        return new GenericBox();
    }
}
