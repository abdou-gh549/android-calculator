package com.tixx.calculatrice.util;


public class ArithmeticEvaluator {

    private final String STR_ERROR_SYNTAX = "syntax error";

    private String expression;
    private int currentChar;
    private int position;

    /**
     * parse and evaluate the given string
     *
     * @return evaluation result
     */
    public double evaluate(String expression) {
        this.expression = expression;
        this.currentChar = -1;
        this.position = -1;

        if (this.expression.isEmpty())
            return 0.;
        return parse();
    }

    private void stepIn() {
        if (++position < expression.length())
            currentChar = expression.charAt(position);
        else
            currentChar = (char) -1;
    }

    private boolean removeChar(int c) {
        while (currentChar == ' ')
            stepIn();
        if (currentChar == c) {
            stepIn();
            return true;
        }
        return false;
    }

    private double parseExpression() {
        double result = parseTerm();
        while (true) {
            // addition
            if (removeChar('+'))
                result += parseTerm();
                // subtraction
            else if (removeChar('-'))
                result -= parseTerm();
            else
                return result;
        }
    }

    private double parseTerm() {
        double result = parseFactor();
        double tmp;
        while (true) {
            // multiplication
            if (removeChar('*'))
                result *= parseFactor();
                // division
            else if (removeChar('/')) {
                tmp = parseFactor();
                if (tmp != 0.)
                    result /= tmp;
                else
                    throw new RuntimeException("division by 0");
            }
            // modulation
            else if (removeChar('%')) {
                tmp = parseFactor();
                if (tmp != 0.)
                    result %= tmp;
                else
                    throw new RuntimeException("modulo 0");
            } else
                return result;
        }
    }

    private double parseFactor() {
        // unary operators + and -
        if (removeChar('+'))
            return parseFactor();
        if (removeChar('-'))
            return -parseFactor();

        double result;
        int startPos = this.position;

        // parentheses
        if (removeChar('(')) {
            result = parseExpression();
            removeChar(')');
        }

        // numbers
        else if ((currentChar >= '0' && currentChar <= '9') || currentChar == '.') {
            while ((currentChar >= '0' && currentChar <= '9') || currentChar == '.')
                stepIn();
            result = Double.parseDouble(expression.substring(startPos, this.position));
        }

        // symbols
        else if (currentChar == 'π') {
            stepIn();
            result = Math.PI;
        } else if (currentChar >= 'a' && currentChar <= 'z') {
            while (currentChar >= 'a' && currentChar <= 'z')
                stepIn();
            String func = expression.substring(startPos, this.position);

            // constants
            if (func.equals("e")) {
                result = Math.exp(1.);
            }

            // functions
            else {
                result = parseFactor();
                switch (func) {
                    case "sqrt":
                        result = Math.sqrt(result);
                        break;
                    case "sin":
                        result = Math.sin(result);
                        break;
                    case "cos":
                        result = Math.cos(result);
                        break;
                    case "tan":
                        result = Math.tan(result);
                        break;
                    case "ln":
                        result = Math.log(result);
                        break;
                    case "log":
                        result = Math.log10(result);
                        break;
                    case "exp":
                        result = Math.exp(result);
                        break;
                    case "fact":
                        result = this.fact(result);
                        break;
                    default:
                        throw new RuntimeException(STR_ERROR_SYNTAX);
                }
            }
        } else
            throw new RuntimeException(STR_ERROR_SYNTAX);

        // power
        if (removeChar('^'))
            result = Math.pow(result, parseFactor());

        return result;
    }

    private double parse() {
        stepIn();
        double result = parseExpression();
        if (this.position < expression.length())
            throw new RuntimeException(STR_ERROR_SYNTAX);
        return result;
    }

    private double fact(double n) {
        double result = 1.;
        while (n >= 2) {
            result *= n--;
        }
        return result;
    }
}