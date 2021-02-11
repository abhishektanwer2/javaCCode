package Leetcode;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class numberformat {
    public static void main(String[] args) {
        double payment=0.25;
        String s="$0.25";
    System.out.println(s.indexOf("."));

        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat cnFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frFormat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        NumberFormat inFormat = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        String us = usFormat.format(payment);
        String us1 = usFormat.format(payment);
        String india = inFormat.format(payment);
        String france = frFormat.format(payment);
        String china = cnFormat.format(payment);
        System.out.println(usFormat.getCurrency());

    }
}
