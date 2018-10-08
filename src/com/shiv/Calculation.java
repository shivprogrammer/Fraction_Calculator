package com.shiv;

import static com.shiv.Operations.*;
import static com.shiv.Conversions.*;

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
                else
                    secondNum = desiredCalculation.substring(i + 1);
            }
            else if (desiredCalculation.charAt(i) == '+'
                    || desiredCalculation.charAt(i) == '-'
                    || desiredCalculation.charAt(i) == '*'
                    || (desiredCalculation.charAt(i) == '/' && desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' '))
                operation = desiredCalculation.charAt(i);
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
}
