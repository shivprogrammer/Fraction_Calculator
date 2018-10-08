package com.shiv;

import static com.shiv.Conversions.calculateMixedFraction;

class Operations {
    static String performOperation(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator, char operation) {
        switch (operation) {
            case '+':
                return calculateMixedFraction(reduce(add(firstNumerator, firstDenominator, secondNumerator, secondDenominator)));
            case '-':
                return calculateMixedFraction(reduce(subtract(firstNumerator, firstDenominator, secondNumerator, secondDenominator)));
            case '*':
                return calculateMixedFraction(reduce(multiply(firstNumerator, firstDenominator, secondNumerator, secondDenominator)));
            case '/':
                // Utilizing a trick of fractional division -- dividing one fraction by another is the same as multiplying the first fraction by the inverse of the second fraction
                return calculateMixedFraction(reduce(multiply(firstNumerator, firstDenominator, secondDenominator, secondNumerator)));
            default:
                return " ";
        }
    }

    private static String add(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        long newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        long newNumerator = firstNumerator * (newDenominator / firstDenominator) + secondNumerator * (newDenominator / secondDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    private static String subtract(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        long newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        long newNumerator = firstNumerator * (newDenominator / firstDenominator) - secondNumerator * (newDenominator / secondDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    private static String multiply(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        long newNumerator = firstNumerator * secondNumerator;
        long newDenominator = firstDenominator * secondDenominator;
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

    static String reduce(String fraction) {
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
