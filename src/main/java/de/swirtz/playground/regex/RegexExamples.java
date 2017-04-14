package de.swirtz.playground.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by simonw on 14.04.17.
 */
public class RegexExamples {
    public static void main(String[] args) {
        Pattern regex = Pattern.compile("[\\s\\d]+");
        String searchStr = "hello 1eoas 21as\n2 1 3 4 1";
        Matcher m = regex.matcher(searchStr);
        while (m.find()){
            System.out.println("Found match at " + m.start() + ":'"+m.group()+"'");
        }
    }

}
