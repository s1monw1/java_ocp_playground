package de.swirtz.playground.misc;

import java.util.StringTokenizer;

/**
 * Created by simonw on 23.04.17.
 */
public class TokenizingExample {

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("ab1c123abcdef123", "123");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
