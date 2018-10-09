package com.shiv.main;

public class Calculation {
    public static String calculateResult(String desiredCalculation, int firstSpaceLocation, int secondFractionStart, String firstNum, String secondNum) {
        char operation = ' ';

        for (int i = firstSpaceLocation; i < secondFractionStart; i++)
            if (desiredCalculation.charAt(i) == '+'
                    || desiredCalculation.charAt(i) == '-'
                    || desiredCalculation.charAt(i) == '*'
                    || (desiredCalculation.charAt(i) == '/'))
                operation = desiredCalculation.charAt(i);

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
