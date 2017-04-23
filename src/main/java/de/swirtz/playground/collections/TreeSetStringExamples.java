package de.swirtz.playground.collections;

import java.io.Console;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by simonw on 15.04.17.
 */
public class TreeSetStringExamples {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>() {
            {
                add("a");
                add("aa");
                add("b");
                add("cc");
                add("bb");
                add("c");
            }
        };
        System.out.println(set);
        TreeSet<String> tree = (TreeSet<String>) set;
        System.out.println("Demo of TreeSet methods");
        System.out.println("First: " + tree.first());
        System.out.println("Last: " + tree.last());
        System.out.println("Ceiling aaa: " + tree.ceiling("aaa"));
        System.out.println("Higher aaa: " + tree.higher("aaa"));
        System.out.println("Floor bb: " + tree.floor("bb"));
        System.out.println("Lower bb: " + tree.lower("bb"));
        System.out.println("Tailset c, include: " + tree.tailSet("c", true));
        System.out.println("HeadSet d, include: " + tree.headSet("d", true));
        System.out.println("Tailset c, do not include: " + tree.tailSet("c", false));
        System.out.println("HeadSet cc, do not include: " + tree.headSet("cc", false));
        tree.pollFirst();
        System.out.println("Tree after pollFirst: " + tree);
        tree.pollLast();
        System.out.println("Tree after pollLast: " + tree);
        NavigableSet<String> tail = tree.tailSet("b", true);
        System.out.println("---------------------\nTailset b included:"+ tail);
        tail.pollFirst();
        System.out.println("Tailset after pollFirst:"+tail);
        System.out.println("Tree after op on subset: "+ tree);

        Console c = System.console();
        c.readLine("Print");
    }
}
