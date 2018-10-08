package com.shiv;

import static com.shiv.Operations.*;

class Calculation {
//public abstract class Calculation {
//    private final String firstNum;
//    private final String secondNum;
//    private final String operation;
//    protected String result;
//
//    public Calculation(String firstNum, String secondNum, String operation) {
//        this.firstNum = firstNum;
//        this.secondNum = secondNum;
//        this.operation = operation;
//        this.result = calculateResult();
//    }
//
//    public abstract String calculateResult();

    static String calculateResult(String desiredCalculation) {
        boolean firstSpaceFound = false;
        char operation = ' ';
        String firstNum = " ";
        String secondNum = " ";

        for (int i = 0; i < desiredCalculation.length(); i++) {
            if (desiredCalculation.charAt((i)) == ' ') {
                if (!firstSpaceFound) {
                    firstNum = desiredCalculation.substring(0, i);
                    firstSpaceFound = true;
                }
                else {
                    secondNum = desiredCalculation.substring(i + 1);
                }
            }
            else if (desiredCalculation.charAt(i) == '+'
                    || desiredCalculation.charAt(i) == '-'
                    || desiredCalculation.charAt(i) == '*'
                    || (desiredCalculation.charAt(i) == '/' && desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ')) {
                operation = desiredCalculation.charAt(i);
            }
        }

        String num1 = getImproperFraction(firstNum);
        String num2 = getImproperFraction(secondNum);

        long num1Numerator = 0L;
        long num1Denominator = 0L;
        long num2Numerator = 0L;
        long num2Denominator = 0L;

        for (int x = 0; x < num1.length(); x++) {
            if (num1.charAt(x) == '/') {
                num1Numerator = Integer.parseInt(num1.substring(0, x));
                num1Denominator = Integer.parseInt(num1.substring(x + 1));
            }
        }

        for (int y = 0; y < num2.length(); y++) {
            if (num2.charAt(y) == '/') {
                num2Numerator = Integer.parseInt(num2.substring(0, y));
                num2Denominator = Integer.parseInt(num2.substring(y + 1));
            }
        }
        return performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
    }
    
    private static String getImproperFraction(String fraction) {
        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '_') {
                return mixedToImproperFraction(fraction);
            }
        }
        return fraction;
    }

    private static String mixedToImproperFraction(String mixed) {
        int underscoreLocation = -1, divideSymbolLocation = -1;

        for (int i = 0; i < mixed.length(); i++) {
            if (mixed.charAt(i) == '_') {
                underscoreLocation = i;
            }
            if (mixed.charAt(i) == '/') {
                divideSymbolLocation = i;
            }
        }

        long denominator = Long.parseLong(mixed.substring(divideSymbolLocation + 1));
        long wholeNumber = Long.parseLong(mixed.substring(0, underscoreLocation));
        long currentNumerator = Integer.parseInt(mixed.substring(underscoreLocation + 1, divideSymbolLocation));
        long newNumerator = wholeNumber * denominator + currentNumerator;
        return Long.toString(newNumerator)+ '/' + Long.toString(denominator);
    }

    static String calculateMixedFraction(String fraction) {
        boolean containsDivideSymbol = false;
        long numerator = 0L;
        long denominator = 0L;

        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '/') {
                numerator = Integer.parseInt(fraction.substring(0, i));
                denominator = Integer.parseInt(fraction.substring(i + 1));
                containsDivideSymbol = true;
            }
        }

        if (!containsDivideSymbol || numerator < denominator) {
            return fraction;
        }

        long wholeNumber = numerator / denominator;
        long newNumerator = numerator - (wholeNumber * denominator);
        return Long.toString(wholeNumber) + '_' + Long.toString(newNumerator) + '/' + Long.toString(denominator);
    }
}
