package com.shiv.main;

import java.util.HashMap;
import static com.shiv.main.Conversions.getImproperFraction;

public class CheckValidInput {
    protected static boolean isUserInputValid(String desiredCalculation) {
        int numberOfSpaces = 0;
        int numberOfValidOperations = 0;
        int firstSpaceLocation = -1;
        int secondSpaceLocation = -1;
        int secondFractionStart = -1;

        for (int i = 0; i < desiredCalculation.length(); i++) {
            if (desiredCalculation.charAt((i)) == ' ') {
                if (i == 0) {
                    System.out.println("Your equation cannot start with a space");
                    return false;
                }
                if (i == desiredCalculation.length() - 1) {
                    System.out.println("Your equation cannot end with a space");
                }
                if ()
                numberOfSpaces++;
                if (firstSpaceLocation < 0)
                    firstSpaceLocation = i;
                else
                    secondSpaceLocation = i;
            }
            // if the character is either '+', '-', '*', '/' AND has an empty character before and after it:
            else if (desiredCalculation.charAt(i) == '+' || desiredCalculation.charAt(i) == '-' || desiredCalculation.charAt(i) == '*' || desiredCalculation.charAt(i) == '/') {
                if (i == 0) {
                    if (desiredCalculation.charAt(i) != '-')
                        return false;
                }
                else if (desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ')
                    numberOfValidOperations++;
            }
        }

        // PROVIDING USER FEEDBACK
        if (numberOfSpaces < 2) {
            System.out.println("Your input: " + desiredCalculation + ", is not separated correctly, please try again: ");
            System.out.println(" ");
            return false;
        }
        if (numberOfValidOperations != 1) {
            if (numberOfValidOperations < 1)
                System.out.println("Your input: " + desiredCalculation + ", does not contain a valid operation, please try again: ");
            if (numberOfValidOperations > 1)
                System.out.println("Your input: " + desiredCalculation + ", must have only one valid operation, please try again: ");
            System.out.println(" ");
            return false;
        }
        if (!isValidFraction(desiredCalculation.substring(0, firstSpaceLocation))) {
            System.out.println("The first parameter of your input: " + desiredCalculation + ", is invalid, please try again: ");
            System.out.println(" ");
            return false;
        }
        if (!isValidFraction(desiredCalculation.substring(secondSpaceLocation + 1))) {
            System.out.println("The second parameter of your input: " + desiredCalculation + ", is invalid, please try again: ");
            System.out.println(" ");
            return false;
        }

        return true;
    }

    private static boolean isValidFraction(String fraction) {
        HashMap<Character, Boolean> numbers = new HashMap<>();
        numbers.put('0', true);
        numbers.put('1', true);
        numbers.put('2', true);
        numbers.put('3', true);
        numbers.put('4', true);
        numbers.put('5', true);
        numbers.put('6', true);
        numbers.put('7', true);
        numbers.put('8', true);
        numbers.put('9', true);

        boolean containsDivideSymbol = false;
        int divideSymbolLocation = -1;
        boolean containsUnderscore = false;
        boolean divideSymbolHasCome = false;
        boolean containsNegative = false;

        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '-') {
                if (containsNegative)
                    return false;
                containsNegative = true;
                if (i != 0 && !numbers.containsKey(fraction.charAt(i + 1)))
                    return false;
            }
            else if (fraction.charAt(i) == '_') {
                if (divideSymbolHasCome) {
                    System.out.println("You have used an invalid mixed number format");
                    return false;
                }
                if (containsUnderscore)
                    return false;
                containsUnderscore = true;

                // if the characters directly before and after the '_' are not numbers:
                if (!numbers.containsKey(fraction.charAt(i - 1)) || !numbers.containsKey(fraction.charAt(i + 1)))
                    return false;
            }
            else if (fraction.charAt(i) == '/') {
                // if the characters directly before and after the '/' are not numbers:
                if (!numbers.containsKey(fraction.charAt(i - 1)) || !numbers.containsKey(fraction.charAt(i + 1)))
                    return false;
                if (containsDivideSymbol)
                    return false;
                containsDivideSymbol = true;
                divideSymbolHasCome = true;
                divideSymbolLocation = i;
            }
            else if (fraction.charAt(i) == '.') {
                System.out.println("Decimals are not allowed, please use a fraction");
                return false;
            }
            else if (!numbers.containsKey(fraction.charAt(i))) {
                System.out.println("There is an invalid character in your input");
                return false;
            }
        }

        if (!containsDivideSymbol) {
            System.out.println("Your input is not a fraction");
            return false;
        }

        // If input is an improper fraction, check validity and provide useful feedback
        if (!containsUnderscore) {
            try {
                Long.parseLong(fraction.substring(0, divideSymbolLocation)); // numerator
            }
            catch (NumberFormatException e) {
                System.out.println("The numerator you have chosen is too large and cannot be computed. ");
                return false;
            }
            try {
                Long.parseLong(fraction.substring(divideSymbolLocation + 1)); // denominator
                if (Long.parseLong(fraction.substring((divideSymbolLocation + 1))) == 0) {
                    System.out.println("You cannot have a fraction with a denominator of 0");
                    return false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("The denominator you have chosen is invalid and cannot be computed. ");
                return false;
            }
        }

        // If input is a mixed number, check validity and provide useful feedback
        if (containsDivideSymbol && containsUnderscore) {
            String improperFraction = getImproperFraction(fraction);

            for (int x = 0; x < improperFraction.length(); x++)
                if (improperFraction.charAt(x) == '/')
                    divideSymbolLocation = x;

            try {
                Long.parseLong(improperFraction.substring(0, divideSymbolLocation)); // numerator
            }
            catch (NumberFormatException e) {
                System.out.println("The numerator you have chosen is too large and cannot be computed. ");
                return false;
            }

            try {
                Long.parseLong(improperFraction.substring(divideSymbolLocation + 1)); // denominator
                if (Long.parseLong(improperFraction.substring((divideSymbolLocation + 1))) == 0) {
                    System.out.println("You cannot have a fraction with a denominator of 0");
                    return false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("The denominator you have chosen is invalid and cannot be computed. ");
                return false;
            }
        }

        return true;
    }
}
