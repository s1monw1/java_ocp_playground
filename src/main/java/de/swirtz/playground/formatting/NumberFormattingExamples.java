package de.swirtz.playground.formatting;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by simonw on 14.04.17.
 */
public class NumberFormattingExamples {

    public static void main(String[] args) throws ParseException {
        double myNum = 123.3255;
        System.out.println("Working with this number: "+myNum);
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("Going to format with "+nf.getClass()+", maxFractionDigits: "+nf.getMaximumFractionDigits());
        System.out.println("Number formatted: "+ nf.format(myNum));
        nf.setMaximumFractionDigits(2);
        System.out.println("Number formatted, fraction digits limited to 2: "+ nf.format(myNum));

        Number n = nf.parse("13,14");
        System.out.println("Random number parsed with NumberFormat: " + n.toString());

        //Currency

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("Going to format currencies with "+currencyFormatter.getClass());
        System.out.println("My number formatted as a currency in default locale: "+currencyFormatter.format(myNum));
        System.out.println("My number formatted as a currency in australian locale: "+NumberFormat.getCurrencyInstance(new Locale("en", "AU")).format(myNum));

    }
}
