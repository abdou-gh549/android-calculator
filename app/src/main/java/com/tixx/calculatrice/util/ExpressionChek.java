package com.tixx.calculatrice.util;

/**
 * Created by abdellah on 4/8/2018.
 */

public class ExpressionChek {

    static public boolean isOperator(String str) {
        return !str.matches("[0123456789)]");
    }

    static public boolean isNumber(String str) {
        return str.matches("[0123456789]");
    }

    static public boolean isNumber(char ch) {
        String str = String.valueOf(ch);
        return str.matches("[0123456789]");
    }
}
