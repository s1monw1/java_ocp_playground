package de.swirtz.playground.collections;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by simonw on 15.04.17.
 */
public class TreeSetExamples {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>() {
            {
                add(8);
                add(4);
                add(12);
                add(10);
                add(6);
                add(2);
            }
        };
        System.out.println(set);
        TreeSet<Integer> tree = (TreeSet<Integer>) set;
        System.out.println("Demo of TreeSet methods");
        System.out.println("First: " + tree.first());
        System.out.println("Last: " + tree.last());
        System.out.println("Ceiling 7: " + tree.ceiling(7));
        System.out.println("Higher 6: " + tree.higher(6));
        System.out.println("Floor 7: " + tree.floor(7));
        System.out.println("Lower 7: " + tree.lower(7));
        System.out.println("Tailset 4, include: " + tree.tailSet(4, true));
        System.out.println("HeadSet 4, include: " + tree.headSet(4, true));
        System.out.println("Tailset 4, do not include: " + tree.tailSet(4, false));
        System.out.println("HeadSet 4, do not include: " + tree.headSet(4, false));
    }
}
