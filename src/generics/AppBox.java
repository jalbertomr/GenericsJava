package generics;

/**
 * Created by Bext on 17/01/2017.
 */
public class AppBox {

    public static void main(String... args) {
        //SimpleBox
        SimpleBox sBox = new SimpleBox();
        sBox.set("Contenido");
        //Integer isb = (Integer)sBox.get();  //se forza a Integer
        // Muestra error hasta runtime java.lang.ClassCastException
        String ssBox = (String) sBox.get();

        SimpleBox sBox2 = new SimpleBox(20);
        SimpleBox sBox3 = new SimpleBox("dato");

        //GenericBox
        //type parameter cannot be a primitive type
        GenericBox<String> gStringBox = new GenericBox<String>();
        gStringBox.set("Contenido en GenericBox");
        String s = gStringBox.get();

        GenericBox<Integer> gIntegerBox = new GenericBox<Integer>();
        gIntegerBox.set(123);
        Integer vI = gIntegerBox.get();

        GenericBox<Double> gDoubleBox = new GenericBox<>();
        gDoubleBox.set(123.2);
        Double vD = gDoubleBox.get();

        //primitive types
        byte varbyte = -128;
        short varshort = 32;
        int varint = 123;
        long varlong = 2131234L;
        float varfloat = 46212123.33F;
        double vardouble = 12.23;
        boolean varboolean = true;
        char varchar = 'w';  // '\u023e'   unicode also

        //GenericBox<double> gdoubleBox = new GenericBox<>(); //Type argument cannot be a primitive type

        //Raw type
        GenericBox rawBox = new GenericBox();
        //rawBox.set("data");
        GenericBox rawBox2 = gStringBox;
        GenericBox rawBox3 = new GenericBox<String>();
        System.out.println("Contenido de genericBox sin inicializar:" + rawBox3.get());
        GenericBox rawBox4 = new GenericBox<String>("con String");
        System.out.println("Contenido de genericBox inicializado:" + rawBox4.get());
        GenericBox rawBox5 = new GenericBox<Integer>();

        GenericBox<Integer> gIntegerBox2 = rawBox;
        Integer i = gIntegerBox2.get();  //aqui genera error String cannot be cast to Integer

    }
}
