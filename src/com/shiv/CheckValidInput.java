package com.shiv;

import java.util.HashMap;

class CheckValidInput {
    static boolean isUserInputValid(String desiredCalculation) {
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
            else if (desiredCalculation.charAt(i) == '+'  || desiredCalculation.charAt(i) == '-'  || desiredCalculation.charAt(i) == '*' || desiredCalculation.charAt(i) == '/') {
                if (desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ')
                    numberOfValidOperations++;
            }
        }

        return numberOfSpaces == 2
                && numberOfValidOperations == 1
                && isValidFraction(desiredCalculation.substring(0, firstSpaceLocation))
                && isValidFraction(desiredCalculation.substring(secondSpaceLocation + 1));
    }

    private static boolean isValidFraction(String fraction) {
//        System.out.println("In the isValidNumber function");
        HashMap<Character, Integer> numbers = new HashMap<>();
        numbers.put('0', 1);
        numbers.put('1', 1);
        numbers.put('2', 1);
        numbers.put('3', 1);
        numbers.put('4', 1);
        numbers.put('5', 1);
        numbers.put('6', 1);
        numbers.put('7', 1);
        numbers.put('8', 1);
        numbers.put('9', 1);

        boolean containsDivideSymbol = false;
        boolean containsUnderscore = false;

        for (int i = 0; i < fraction.length(); i++) {
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
            }
            else if (fraction.charAt(i) == '-') {
                if (i != 0 && fraction.charAt(i - 1) != ' ')
                    return false;
                if (!numbers.containsKey(fraction.charAt(i + 1)))
                    return false;
            }
            else if (!numbers.containsKey(fraction.charAt(i)))
                return false;
        }

        return containsDivideSymbol;
    }
}
