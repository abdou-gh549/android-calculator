package com.tixx.calculatrice.util;

public class ExpressionCheck {

    static public boolean isOperator(String str) {
        return !str.matches("[0123456789π)]");
    }

    static public boolean isNumber(String str) {
        return str.matches("[0123456789π]");
    }

    static public boolean isNumber(char ch) {
        String str = String.valueOf(ch);
        return str.matches("[0123456789π]");
    }
}
