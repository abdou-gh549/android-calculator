package com.tixx.calculatrice.advanceOperator;

/**
 * Created by abdellah on 4/7/2018.
 */
import static com.tixx.calculatrice.util.ExpressionChek.isNumber;
import static com.tixx.calculatrice.util.ExpressionChek.isOperator;


public class AdvanceOperatorModel {

    public String addPowerOperator(String input) {
        if(input.isEmpty()|| isOperator( getLastChar(input))){
            return "";
        }
        return "^";
    }


    private String getLastChar(String str) {
        if (!str.isEmpty()) {
            return (str.length() == 1) ? str : String.valueOf(str.charAt(str.length() - 1));
        } else return "";
    }

    public String addOperator(String input, String operator) {
        if( isNumber(getLastChar(input)))
            return "";
        else
            return operator+"(";
    }
}
