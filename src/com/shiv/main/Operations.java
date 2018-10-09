package com.shiv.main;

import static com.shiv.main.Conversions.calculateMixedFraction;

public class Operations {
    static String performOperation(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator, char operation) {
//        System.out.println("IN THE PERFORM OPERATION METHOD");
//        System.out.println("operation: " + operation);
        if (firstDenominator == 0 || secondDenominator == 0) {
            return "Your fraction cannot have a denominator of 0";
        }

        switch (operation) {
            case '+':
                return calculateMixedFraction(reduce(add(firstNumerator, firstDenominator, secondNumerator, secondDenominator)));
            case '-':
                return calculateMixedFraction(reduce(subtract(firstNumerator, firstDenominator, secondNumerator, secondDenominator)));
            case '*':
                return calculateMixedFraction(reduce(multiply(firstNumerator, firstDenominator, secondNumerator, secondDenominator)));
            case '/':
                if (secondNumerator == 0)
                    return "You cannot divide by a 0 fraction";
                // shifting the negative sign prior to entering the next function
                if (secondNumerator < 0) {
                    secondNumerator *= -1;
                    secondDenominator *= -1;
                }
                // Utilizing a trick of fractional division -- dividing one fraction by another is the same as multiplying the first fraction by the inverse of the second fraction
                return calculateMixedFraction(reduce(multiply(firstNumerator, firstDenominator, secondDenominator, secondNumerator)));
            default:
                return " ";
        }
    }

    private static String add(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        if (firstNumerator == 0)
            return Long.toString(secondNumerator) + '/' + Long.toString(secondDenominator);
        if (secondNumerator == 0)
            return Long.toString(firstNumerator) + '/' + Long.toString(firstDenominator);

        long newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        long newNumerator = firstNumerator * (newDenominator / firstDenominator) + secondNumerator * (newDenominator / secondDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    private static String subtract(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        if (firstNumerator == 0)
            return '-' + Long.toString(secondNumerator) + '/' + Long.toString(secondDenominator);
        if (secondNumerator == 0)
            return Long.toString(firstNumerator) + '/' + Long.toString(firstDenominator);

        long newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        long newNumerator = firstNumerator * (newDenominator / firstDenominator) - secondNumerator * (newDenominator / secondDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    private static String multiply(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        if (firstNumerator == 0 || secondNumerator == 0)
            return "0";

        long newNumerator = firstNumerator * secondNumerator;
//        System.out.println("newNumerator: " + newNumerator);
        long newDenominator = firstDenominator * secondDenominator;
//        System.out.println("newDenominator: " + newDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    private static long findLowestCommonMultiple(long firstNum, long secondNum) {
        if (firstNum % secondNum == 0)
            return firstNum;

        if (secondNum % firstNum == 0)
            return secondNum;

        long lowestCommonMultiple = firstNum * secondNum;
        while (lowestCommonMultiple % firstNum == 0 && lowestCommonMultiple % secondNum == 0)
            lowestCommonMultiple /= 2;

        return lowestCommonMultiple * 2;
    }

    protected static String reduce(String fraction) {
        int divideSymbolLocation = -1;

        for (int i = 0; i < fraction.length(); i++)
            if (fraction.charAt(i) == '/')
                divideSymbolLocation = i;

        long numerator = Long.parseLong(fraction.substring(0, divideSymbolLocation));
        long denominator = Long.parseLong(fraction.substring(divideSymbolLocation + 1));

        return reduceHelper(numerator, denominator);
    }

    private static String reduceHelper(long numerator, long denominator) {
        if (numerator % denominator == 0) {
            long reduced = numerator / denominator;
            return Long.toString(reduced);
        }

        long smaller = (numerator < denominator) ? numerator : denominator;

        for (int i = 2; i <= smaller; i++)
            if (numerator % i == 0 && denominator % i == 0)
                return reduceHelper(numerator / i, denominator / i);

        return Long.toString(numerator) + '/' + Long.toString(denominator);
    }
}
