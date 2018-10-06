package com.shiv;

public class Operations {
//    public static String calculateResult(String firstNum, String secondNum, String operation) {
//        String num1 = getImproperFraction(firstNum);
//        String num2 = getImproperFraction(secondNum);
//        int num1Numerator = 0;
//        int num1Denominator = 0;
//        int num2Numerator = 0;
//        int num2Denominator = 0;
//
//        for (int x = 0; x < num1.length(); x++) {
//            if (num1.charAt(x) == '/') {
//                num1Numerator = Integer.parseInt(num1.substring(0, x));
//                num1Denominator = Integer.parseInt(num1.substring(x + 1, num1.length()));
//            }
//        }
//
//        for (int y = 0; y < num2.length(); y++) {
//            if (num2.charAt(y) == '/') {
//                num2Numerator = Integer.parseInt(num2.substring(0, y));
//                num2Denominator = Integer.parseInt(num2.substring(y + 1, num2.length()));
//            }
//        }
//
//        return performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
////        return resultsMessage(firstNum, secondNum, operation, result);
//    }
//
//    public static String performOperation(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator, String operation) {
//        if (operation.equals("add")) {
//            String result = add(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
//            return reduce(result);
//        }
//        else if (operation.equals("subtract")) {
//            String result = subtract(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
//            return reduce(result);
//        }
//        else if (operation.equals("multiply")) {
//            String result = multiply(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
//            return reduce(result);
//        }
//        // Utilizing a trick of fractional division -- dividing one fraction by another is the same as multiplying the first fraction by the inverse of the second fraction
//        else if (operation.equals("divide")) {
//            String result = multiply(firstNumerator, firstDenominator, secondDenominator, secondNumerator);
//            return reduce(result);
//        }
//        return "";
//    }
//
//    public static String multiply(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
//        int newNumerator = firstNumerator * secondNumerator;
//        int newDenominator = firstDenominator * secondDenominator;
//        return Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
//    }
//
//    public static String add(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
//        int newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
//        int newNumerator = firstNumerator * (newDenominator / firstDenominator) + secondNumerator * (newDenominator / secondDenominator);
//        return Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
//    }
//
//    public static String subtract(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
//        int newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
//        int newNumerator = firstNumerator * (newDenominator / firstDenominator) - secondNumerator * (newDenominator / secondDenominator);
//        return Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
//    }
}
