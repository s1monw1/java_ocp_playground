package de.swirtz.playground.formatting;

/**
 * Created by simonw on 21.04.17.
 */
public class FormatterExamples {

    public static void main(String[] args) {
        System.out.printf("\"%(-,10.3f\"", -100.);
        System.out.println();
        System.out.printf("\"%-,10.3f\"", -100.);
        System.out.println();
        System.out.printf("\"%-10s\"", "hello");
    }
}
