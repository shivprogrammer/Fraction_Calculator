package com.shiv.main;

import static com.shiv.main.FractionCalculator.displayResult;

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

        for (int x = 0; x < num1.length(); x++) {
            if (num1.charAt(x) == '/') {
//                try {
                    num1Numerator = Long.parseLong(num1.substring(0, x));
                    num1Denominator = Long.parseLong(num1.substring(x + 1));
//                } catch (NumberFormatException e) {
//                    System.out.println("The result of the numbers you have chosen is too large, please try again: ");
//                    gatherCalculationInfo();
//                }
            }
        }

        for (int y = 0; y < num2.length(); y++) {
            if (num2.charAt(y) == '/') {
//                try {
                    num2Numerator = Long.parseLong(num2.substring(0, y));
                    num2Denominator = Long.parseLong(num2.substring(y + 1));
//                } catch (NumberFormatException e) {
//                    System.out.println("The result of the numbers you have chosen is too large, please try again: ");
//                    gatherCalculationInfo();
//                }
            }
        }

//        System.out.println("num1Numerator: " + num1Numerator);
//        System.out.println("num1Denominator: " + num1Denominator);
//        System.out.println("num2Numerator: " + num2Numerator);
//        System.out.println("num2Denominator: " + num2Denominator);
//        System.out.println("operation: " + operation);

        String result = Operations.performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
//        giveResult(desiredCalculation, result);
        return result;
    }

//    public static void giveResult(String desiredCalculation, String result) {
//        displayResult(desiredCalculation, result);
//    }
}
