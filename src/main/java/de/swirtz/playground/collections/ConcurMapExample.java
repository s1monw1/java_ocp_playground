package de.swirtz.playground.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by simonw on 17.04.17.
 */
public class ConcurMapExample {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> cm = new ConcurrentHashMap<>();
        cm.put("a", "erster");
        cm.put("b", "zweiter");
        cm.put("c", "dritter");
        cm.put("d", "vierter");
        System.out.println("Working with "+cm);
        String absent = cm.putIfAbsent("a", "erster");
        System.out.println("a=erster putIfAbsent?"+ absent);
        boolean removed = cm.remove("a", "irgendwas");
        System.out.println("Tried to remove a=irgendwas: "+ removed);
        boolean replace = cm.replace("b", "zweiter", "zweiterR");
        System.out.println("Replace b=zweiter mit newVal zweiterR: "+replace);
        System.out.println("Working with "+cm);
    }
}
