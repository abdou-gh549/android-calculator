package com.tixx.calculatrice.advanceOperator;

import static com.tixx.calculatrice.util.ExpressionCheck.isNumber;
import static com.tixx.calculatrice.util.ExpressionCheck.isOperator;


public class AdvanceOperatorModel {

    public String addPowerOperator(String input) {
        return (input.isEmpty() || isOperator(getLastChar(input))) ? "" : "^";
    }

    private String getLastChar(String str) {
        if (!str.isEmpty())
            return (str.length() == 1) ? str : String.valueOf(str.charAt(str.length() - 1));
        else return "";
    }

    public String addOperator(String input, String operator) {
        String lastChar = getLastChar(input);
        return (isNumber(lastChar) || ")".equals(lastChar)) ? "" : operator + "(";
    }
}
