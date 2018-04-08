package com.tixx.calculatrice.basicCalculator;


import static com.tixx.calculatrice.util.ExpressionChek.isNumber;
import static com.tixx.calculatrice.util.ExpressionChek.isOperator;

public class BasicCalculatorModel {


    public String validateNewNumberInput(String oldInput, int buttonTage) {
        if ("0".equals(oldInput) && buttonTage == 0) {
            return "";
        } else return String.valueOf(buttonTage);
    }

    public String validateNewBasicOperatorInput(String oldInput, String operator) {
        String inputToAdd = "";
        if ("-".equals(operator) && !getLastChar(oldInput).equals("-")) {
            inputToAdd = "-";
        } else if (!isOperator(getLastChar(oldInput))) {
            inputToAdd = operator;
        }
        return inputToAdd;
    }

    public String validateNewPointInput(String inp) {
        String inputToAdd = "";

        if (inp.isEmpty())
            inputToAdd = "0.";

        else if (isNumber(getLastChar(inp))) {
            int inpLength = inp.length();

            while (inpLength >= 1 && isNumber(inp.charAt(inpLength - 1)))
                inpLength--;

            if (inpLength == 0 || Character.compare('.', inp.charAt(inpLength - 1)) != 0) {
                inputToAdd = ".";
            }
        }

        return inputToAdd;

    }

    private String getLastChar(String str) {
        if (!str.isEmpty()) {
            return (str.length() == 1) ? str : String.valueOf(str.charAt(str.length() - 1));
        } else return "";
    }

    public int backSpace(String input) {
        try {
            if (!input.isEmpty()) {
                String subString = input.substring(0, input.length() - 1);
                String lastChar = getLastChar(subString);
                if ("t".equals(lastChar))
                    return 5;

                else if ("s".equals(lastChar) ||
                        "g".equals(lastChar) ||
                        "p".equals(lastChar)) {
                    return 4;
                } else if ("n".equals(lastChar)) {
                    String secondlastChar = getLastChar(input.substring(0, input.length() - 2));
                    return ("l".equals(secondlastChar)) ? 3 : 4;
                } else return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }


    }
}
