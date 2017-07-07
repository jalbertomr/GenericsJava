package generics;

import sun.net.www.content.text.Generic;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bext on 19/01/2017.
 */
public class BoxTypeInference {

    public static <U> void addBox(U u, java.util.List<GenericBox<U>> listBox) {
        GenericBox<U> box = new GenericBox<>();
        box.set(u);
        listBox.add(box);
    }

    public static <U> void outputBoxes(java.util.List<GenericBox<U>> listBox){
        int counter = 0;
        for (GenericBox<U> box: listBox){
            U boxContents = box.get();
            System.out.println("Box #" + counter +" contiene: " + boxContents);
            ++counter;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<GenericBox<Integer>> listOfIntegerBox = new java.util.ArrayList<>();

        BoxTypeInference.<Integer>addBox(Integer.valueOf(12), listOfIntegerBox);
        BoxTypeInference.addBox(Integer.valueOf(34), listOfIntegerBox);
        BoxTypeInference.addBox(Integer.valueOf(54), listOfIntegerBox);
        BoxTypeInference.outputBoxes(listOfIntegerBox);

        java.util.ArrayList<GenericBox<String>> listOfStringBox = new java.util.ArrayList<>();

        BoxTypeInference.<String>addBox("Aire", listOfStringBox);
        BoxTypeInference.addBox("fuego", listOfStringBox);
        BoxTypeInference.addBox("tierra", listOfStringBox);
        BoxTypeInference.outputBoxes( listOfStringBox);

        Map<String, List<String>> myMap = new HashMap<String, List<String>>();
        Map<String, List<String>> myMap2 = new HashMap<>();
    }
}
