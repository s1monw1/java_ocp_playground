package de.swirtz.playground.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by simonw on 23.04.17.
 */
public class PathCombineExamples {

    public static void main(String[] args) {
        Path p1 = Paths.get("src/main");
        Path p2 = Paths.get("/Users");
        Path p3 = Paths.get("/Users/Sim");
        System.out.println("Resolve p1="+p1.toString()+" with p2="+p2.toString()+" -> "+p1.resolve(p2));
        System.out.println("Resolve p1="+p2.toString()+" with p2="+p1.toString()+" -> "+p2.resolve(p1));
        System.out.println("Relativize p1="+p3.toString()+" with p2="+p2.toString()+" -> "+p3.relativize(p2));
        System.out.println("Relativize p1="+p2.toString()+" with p2="+p3.toString()+" -> "+p2.relativize(p3));


    }
}
