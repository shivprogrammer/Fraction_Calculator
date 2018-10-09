package com.shiv.main;

import static com.shiv.main.FractionCalculator.displayResult;

public class Calculation {
    public static String calculateResult(String desiredCalculation, int firstSpaceLocation, int secondFractionStart, String firstNum, String secondNum) {
//        boolean firstSpaceFound = false;
//        boolean operationFound = false;
        char operation = ' ';
//        String firstNum = " ";
//        String secondNum = " ";

//        for (int i = 0; i < desiredCalculation.length(); i++) {
//            if (desiredCalculation.charAt((i)) == ' ') {
//                if (!firstSpaceFound) {
//                    firstNum = desiredCalculation.substring(0, i);
//                    firstSpaceFound = true;
//                }
//                else if (operationFound && )
//                else
//                    secondNum = desiredCalculation.substring(i + 1);
//            }
            // Specifically for the divide sign, there must be a space before and after to confirm validity of division operator
//            else if (desiredCalculation.charAt(i) == '+'
//                    || desiredCalculation.charAt(i) == '-' && desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' '
//                    || desiredCalculation.charAt(i) == '*'
//                    || (desiredCalculation.charAt(i) == '/' && desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ')) {
//                operation = desiredCalculation.charAt(i);
//                operationFound = true;
//            }
        for (int i = firstSpaceLocation; i < secondFractionStart; i++)
            if (desiredCalculation.charAt(i) == '+'
                    || desiredCalculation.charAt(i) == '-'
                    || desiredCalculation.charAt(i) == '*'
                    || (desiredCalculation.charAt(i) == '/'))
                operation = desiredCalculation.charAt(i);

//        String firstNum = desiredCalculation.substring()
        String num1 = Conversions.getImproperFraction(firstNum);
//        System.out.println("num1: " + num1);
        String num2 = Conversions.getImproperFraction(secondNum);
//        System.out.println("num2: " + num2);

        long num1Numerator = 0L;
        long num1Denominator = 0L;
        long num2Numerator = 0L;
        long num2Denominator = 0L;

        for (int x = 0; x < num1.length(); x++) {
            if (num1.charAt(x) == '/') {
                try {
                    num1Numerator = Long.parseLong(num1.substring(0, x));
                    num1Denominator = Long.parseLong(num1.substring(x + 1));
                } catch (NumberFormatException e) {
                    System.out.println("The result of the numbers you have chosen is too large, please try again: ");
//                    gatherCalculationInfo();
                }
            }
        }

        for (int y = 0; y < num2.length(); y++) {
            if (num2.charAt(y) == '/') {
                try {
                    num2Numerator = Long.parseLong(num2.substring(0, y));
                    num2Denominator = Long.parseLong(num2.substring(y + 1));
                } catch (NumberFormatException e) {
                    System.out.println("The result of the numbers you have chosen is too large, please try again: ");
//                    gatherCalculationInfo();
                }
            }
        }

//        System.out.println("num1Numerator: " + num1Numerator);
//        System.out.println("num1Denominator: " + num1Denominator);
//        System.out.println("num2Numerator: " + num2Numerator);
//        System.out.println("num2Denominator: " + num2Denominator);
//        System.out.println("operation: " + operation);

        return Operations.performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
    }
}
