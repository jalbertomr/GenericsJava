package generics;

import org.codehaus.groovy.tools.shell.CommandRegistry;

import java.util.ArrayList;
import java.util.List;

/**Wildcard Guidelines:

 An "IN" variable is defined with an UPPER bounded wildcard, using the EXTENDS keyword.
 An "OUT" variable is defined with a LOWER bounded wildcard, using the SUPER keyword.
 In the case where the "in" variable can be accessed using methods defined in the Object class, use an unbounded wildcard. <?></?>
 In the case where the code needs to access the variable as both an "in" and an "out" variable, do not use a wildcard.

 */
public class GuideLines {

    static class NaturalNumber {
       private int i;
       public NaturalNumber(int i) { this.i = i;}
    }

    static class EvenNumber extends NaturalNumber {
       public EvenNumber(int i) { super(i);}
    }

    public static void main(String... args) {
        List<EvenNumber> le = new ArrayList<>();
        //le is a subtype of ln, so can be assigned le subtype to ln supertype
        List<? extends NaturalNumber> ln = le;

        // Error cannot use ln to add a naturalNumber to a list of evenNumbers
        //ln.add( new EvenNumber( 35));
        //ln.add(new NaturalNumber(10));
        //ln.add(new EvenNumber( 5));
        //Only this adds are possible
        ln.add( null );
        ln.clear();
        ln.add( null);
        ln.remove(0);

        //
        List<? super EvenNumber> lsuperEven = new ArrayList<>();
        lsuperEven.add( new EvenNumber(5));
        //Error NaturalNumber cannot be cast to EvenNumber
        //lsuperEven.add( new NaturalNumber(5));
        //lsuperEven.add( (EvenNumber)new NaturalNumber(35));

        List<? extends EvenNumber> lEven = new ArrayList<>();
        List<? extends NaturalNumber> lNatPointEven = lEven;
        //Errores
        //lNatPointEven.add( new EvenNumber( 5));
        //lNatPointEven.add( new NaturalNumber( 10));
        //lNatPointEven.add( (NaturalNumber) new EvenNumber(5));
        //lNatPointEven.add( (EvenNumber)new NaturalNumber(10));
    }
}
