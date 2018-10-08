package com.shiv.main;

public class Conversions {
    static String getImproperFraction(String fraction) {
        for (int i = 0; i < fraction.length(); i++)
            if (fraction.charAt(i) == '_')
                return mixedToImproperFraction(fraction);

        return fraction;
    }

    private static String mixedToImproperFraction(String mixed) {
        int underscoreLocation = -1;
        int divideSymbolLocation = -1;

        for (int i = 0; i < mixed.length(); i++) {
            if (mixed.charAt(i) == '_')
                underscoreLocation = i;
            if (mixed.charAt(i) == '/')
                divideSymbolLocation = i;
        }

        long denominator = Long.parseLong(mixed.substring(divideSymbolLocation + 1));
        long wholeNumber = Long.parseLong(mixed.substring(0, underscoreLocation));
        long currentNumerator = Long.parseLong(mixed.substring(underscoreLocation + 1, divideSymbolLocation));
        long newNumerator = wholeNumber * denominator + currentNumerator;

        return Long.toString(newNumerator) + '/' + Long.toString(denominator);
    }

    static String calculateMixedFraction(String fraction) {
        boolean containsDivideSymbol = false;
        long numerator = 0L;
        long denominator = 0L;

        for (int i = 0; i < fraction.length(); i++)
            if (fraction.charAt(i) == '/') {
                numerator = Long.parseLong(fraction.substring(0, i));
                denominator = Long.parseLong(fraction.substring(i + 1));
                containsDivideSymbol = true;
            }

        if (!containsDivideSymbol || numerator < denominator)
            return fraction;

        long wholeNumber = numerator / denominator;
        long newNumerator = numerator - (wholeNumber * denominator);

        return Long.toString(wholeNumber) + '_' + Long.toString(newNumerator) + '/' + Long.toString(denominator);
    }
}
