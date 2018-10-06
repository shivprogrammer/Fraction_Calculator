package com.shiv;

public class Conversions {
//    public static int findLowestCommonMultiple(int firstNum, int secondNum) {
//        int lowestCommonMultiple;
//        if (firstNum % secondNum == 0) {
//            lowestCommonMultiple = firstNum;
//            return lowestCommonMultiple;
//        }
//        if (secondNum % firstNum == 0) {
//            lowestCommonMultiple = secondNum;
//            return lowestCommonMultiple;
//        }
//
//        lowestCommonMultiple = firstNum * secondNum;
//
//        while (lowestCommonMultiple % firstNum == 0 && lowestCommonMultiple % secondNum == 0) {
//            lowestCommonMultiple /= 2;
//        }
//        return lowestCommonMultiple * 2;
//    }
//
//    public static String reduce(String fraction) {
//        int divideSymbolLocation = -1;
//
//        for (int i = 0; i < fraction.length(); i++) {
//            if (fraction.charAt(i) == '/') {
//                divideSymbolLocation = i;
//            }
//        }
//
//        int numerator = Integer.parseInt(fraction.substring(0, divideSymbolLocation));
//        int denominator = Integer.parseInt(fraction.substring(divideSymbolLocation + 1, fraction.length()));
//
//        return reducer(numerator, denominator);
//    }
//
//    public static String reducer(int numerator, int denominator) {
//        if (numerator % denominator == 0) {
//            int reduced = numerator / denominator;
//            return Integer.toString(reduced);
//        }
//
//        int smaller = (numerator < denominator) ? numerator : denominator;
//        for (int i = 2; i <= smaller; i++) {
//            if (numerator % i == 0 && denominator % i == 0) {
//                return reducer(numerator / i,denominator / i);
//            }
//        }
//        return Integer.toString(numerator) + '/' + Integer.toString(denominator);
//    }
//
//    public static String getImproperFraction(String fraction) {
//        for (int i = 0; i < fraction.length(); i++) {
//            if (fraction.charAt(i) == '_') {
//                return mixedToImproperFraction(fraction);
//            }
//        }
//        return fraction;
//    }
//
//    public static String mixedToImproperFraction(String mixed) {
//        int underscoreLocation = -1, divideSymbolLocation = -1;
//
//        for (int i = 0; i < mixed.length(); i++) {
//            if (mixed.charAt(i) == '_') {
//                underscoreLocation = i;
//            }
//            if (mixed.charAt(i) == '/') {
//                divideSymbolLocation = i;
//            }
//        }
//
//        int denominator = Integer.parseInt(mixed.substring(divideSymbolLocation + 1, mixed.length()));
//        int wholeNumber = Integer.parseInt(mixed.substring(0, underscoreLocation));
//        int currentNumerator = Integer.parseInt(mixed.substring(underscoreLocation + 1, divideSymbolLocation));
//        int newNumerator = wholeNumber * denominator + currentNumerator;
//        return Integer.toString(newNumerator)+ '/' + Integer.toString(denominator);
//    }

//    public static String calculateMixedFraction(String fraction) {
//        return "";
//    }
}
