package de.swirtz.playground.resourcebundles;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by simonw on 14.04.17.
 */
public class I18nExample {

    public static void main(String[] args) throws ClassNotFoundException {

        Locale l = new Locale("de");
        ResourceBundle rb = ResourceBundle.getBundle("de.swirtz.playground.resourcebundles.Resources");
        printContent(rb);
        rb = ResourceBundle.getBundle("de.swirtz.playground.resourcebundles.Resources", Locale.ENGLISH);
        printContent(rb);

    }

    private static void printContent(ResourceBundle rb) {
        Enumeration<String> keys = rb.getKeys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println("RB contains Key: "+ key);
            System.out.println("Value: "+ rb.getString(key));
        }
    }

}
