/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatternsday03strategypattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 1999k
 */
interface Strategy {

    public boolean find(String content, String symbol);

}

class Strategy1 implements Strategy {

    @Override
    public boolean find(String content, String symbol) {
        if (content.contains(symbol)) {
            return true;
        } else {
            return false;
        }
    }

}

class Strategy2 implements Strategy {

    @Override
    public boolean find(String content, String symbol) {
        if (content.indexOf(symbol) > 0) {
            return true;
        } else {
            return false;
        }
    }

}

class Strategy3 implements Strategy {

    @Override
    public boolean find(String content, String symbol) {
        Matcher matcher = Pattern.compile(symbol).matcher(content);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

}

class Strategy4 implements Strategy {

    @Override
    public boolean find(String content, String symbol) {
        boolean res = false;
        for (int i = 0; i < content.length(); i++) {
            if (String.valueOf(content.charAt(i)).equals(symbol)) {
                res = true;
                break;
            }
        }

        if (res) {
            return true;
        } else {
            return false;
        }
    }

}

public class Test {

    public static void main(String[] args) {

        String text = "tharaka@javainstitute.edu.lk";

        Strategy1 str1 = new Strategy1();
        System.out.println("Strategy 1");
        if (str1.find(text, "@")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        Strategy2 str2 = new Strategy2();
        System.out.println("Strategy 2");
        if (str2.find(text, "@")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        Strategy3 str3 = new Strategy3();
        System.out.println("Strategy 3");
        if (str3.find(text, "@")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        Strategy4 str4 = new Strategy4();
        System.out.println("Strategy 4");
        if (str4.find(text, "@")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

    }

}
