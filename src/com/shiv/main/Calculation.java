package com.shiv.main;

public class Calculation {
    public static String calculateResult(String desiredCalculation) {
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
            // Specifically for the divide sign, there must be a space before and after to confirm validity of division operator
            else if (desiredCalculation.charAt(i) == '+'
                    || desiredCalculation.charAt(i) == '-'
                    || desiredCalculation.charAt(i) == '*'
                    || (desiredCalculation.charAt(i) == '/' && desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' '))
                operation = desiredCalculation.charAt(i);
        }

        String num1 = Conversions.getImproperFraction(firstNum);
        String num2 = Conversions.getImproperFraction(secondNum);

        long num1Numerator = 0L;
        long num1Denominator = 0L;
        long num2Numerator = 0L;
        long num2Denominator = 0L;

        for (int x = 0; x < num1.length(); x++)
            if (num1.charAt(x) == '/') {
                num1Numerator = Long.parseLong(num1.substring(0, x));
                num1Denominator = Long.parseLong(num1.substring(x + 1));
            }

        for (int y = 0; y < num2.length(); y++)
            if (num2.charAt(y) == '/') {
                num2Numerator = Long.parseLong(num2.substring(0, y));
                num2Denominator = Long.parseLong(num2.substring(y + 1));
            }

        return Operations.performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
    }
}
