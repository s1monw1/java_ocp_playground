package de.swirtz.playground.formatting;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by simonw on 14.04.17.
 */
public class DateFormattingExamples {

    public static final long TRILL = 1_000_000_000_000L;

    public static void main(String[] args) {
        Date myDate = new Date(TRILL);
        System.out.println("MyDate: " + myDate.toString());
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(myDate);
        System.out.println("MyCal: " + myCal.toString());
        myCal.set(2017, 1, 1, 14, 20);
        DateFormat dF = DateFormat.getDateInstance();
        System.out.println("Going to format with "+dF.getClass());
        String calFormatted = dF.format(myCal.getTime());
        System.out.println("MyCal formatted: "+ calFormatted);
        dF=DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("MyCal formatted fully: "+dF.format(myCal.getTime()));

        //Using Locales
        Locale nl = new Locale("nl", "NL");
        System.out.println("\nNow using Locale: "+nl.getDisplayCountry()+", "+nl.getDisplayLanguage());

        DateFormat locatedDf = DateFormat.getDateInstance(DateFormat.FULL, nl);
        System.out.println("MyCal formatted locale: "+ locatedDf.format(myCal.getTime()));

    }
}
