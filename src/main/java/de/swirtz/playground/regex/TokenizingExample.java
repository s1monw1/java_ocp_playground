package de.swirtz.playground.regex;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by simonw on 14.04.17.
 */
public class TokenizingExample
{

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(Paths.get("src/main/resources/test.txt"));
//        s.useDelimiter("a");
        while (s.hasNext()){
            System.out.println("Scanner found word: "+s.next());
        }

    }
}
