package com.shiv.main;

import java.util.HashMap;
import static com.shiv.main.Conversions.getImproperFraction;

public class CheckValidInput {
    protected static boolean isUserInputValid(String desiredCalculation) {
        int numberOfSpaces = 0;
        int numberOfValidOperations = 0;
        int firstSpaceLocation = -1;
        int secondSpaceLocation = -1;

        for (int i = 0; i < desiredCalculation.length(); i++) {
            if (desiredCalculation.charAt((i)) == ' ') {
                numberOfSpaces++;
                if (firstSpaceLocation < 0)
                    firstSpaceLocation = i;
                else
                    secondSpaceLocation = i;
            }
            // if the character is either '+', '-', '*', '/' AND has an empty character before and after it:
            else if (desiredCalculation.charAt(i) == '+' || desiredCalculation.charAt(i) == '-' || desiredCalculation.charAt(i) == '*' || desiredCalculation.charAt(i) == '/') {
                if (desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ')
                    numberOfValidOperations++;
            }
        }

        // PROVIDING USER FEEDBACK
        if (numberOfSpaces != 2) {
            if (numberOfSpaces < 2)
                System.out.println("Your input: " + desiredCalculation + ", is not separated correctly, please try again: ");
            if (numberOfSpaces > 2)
                System.out.println("Your input: " + desiredCalculation + ", contains too many spaces, please try again: ");
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
//        System.out.println("fraction: " + fraction);
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

        for (int i = 0; i < fraction.length(); i++)
            if (fraction.charAt(i) == '_') {
                // if the characters directly before and after the '_' are not numbers:
                if (!numbers.containsKey(fraction.charAt(i - 1)) || !numbers.containsKey(fraction.charAt(i + 1)))
                    return false;
                if (containsUnderscore)
                    return false;
                containsUnderscore = true;
            }
            else if (fraction.charAt(i) == '/') {
                // if the characters directly before and after the '/' are not numbers:
                if (!numbers.containsKey(fraction.charAt(i - 1)) || !numbers.containsKey(fraction.charAt(i + 1)))
                    return false;
                if (containsDivideSymbol)
                    return false;
                containsDivideSymbol = true;
                divideSymbolLocation = i;
            }
            // WORKING WITH NEGATIVE NUMBERS
//            else if (fraction.charAt(i) == '-') {
//                if (i != 0 && fraction.charAt(i - 1) != ' ')
//                    return false;
//                if (!numbers.containsKey(fraction.charAt(i + 1)))
//                    return false;
//            }
            else if (!numbers.containsKey(fraction.charAt(i)))
                return false;

        if (!containsDivideSymbol) {
            System.out.println("Your first parameter is not a fraction.");
            return false;
        }
        // Checking the validity of an improper fraction to provide useful user feedback
        if (!containsUnderscore) {
//            System.out.println("DEALING WITH AN IMPROPER FRACTION");

            // VALID NUMERATOR CHECK
            try {
                Long.parseLong(fraction.substring(0, divideSymbolLocation));
//                System.out.println("numerator: " + Long.parseLong(fraction.substring(0, divideSymbolLocation)));
            }
            catch (NumberFormatException e) {
                System.out.println("The numerator you have chosen is too large and cannot be computed. ");
                return false;
            }

            // VALID DENOMINATOR CHECK
            try {
                Long.parseLong(fraction.substring(divideSymbolLocation + 1));
//                System.out.println("denominator: " + Long.parseLong(fraction.substring(divideSymbolLocation + 1)));

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

        // checking the validity of the mixed number
        if (containsDivideSymbol && containsUnderscore) {
//            System.out.println("DEALING WITH A MIXED NUMBER");

            String improperFraction = getImproperFraction(fraction);
//            System.out.println("improperFraction: " + improperFraction);

            for (int x = 0; x < improperFraction.length(); x++) {
                if (improperFraction.charAt(x) == '/') {
                    divideSymbolLocation = x;
                }
            }

            // VALID NUMERATOR CHECK
            try {
                Long.parseLong(improperFraction.substring(0, divideSymbolLocation));
//                System.out.println("Valid Numerator: " + Long.parseLong(improperFraction.substring(0, divideSymbolLocation)));
            }
            catch (NumberFormatException e) {
                System.out.println("The numerator you have chosen is too large and cannot be computed. ");
                return false;
            }

            // VALID DENOMINATOR CHECK
            try {
//                System.out.println("Denominator in string form: " + improperFraction.substring(divideSymbolLocation));
                Long.parseLong(improperFraction.substring(divideSymbolLocation + 1));
//                System.out.println("Valid Denominator: " + Long.parseLong(improperFraction.substring(divideSymbolLocation + 1)));

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
