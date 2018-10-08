package com.shiv;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner consoleInput = new Scanner(System.in);

    public static void gatherCalculationInfo() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=======================================================================================");
        System.out.println("                        Welcome to the Fraction Calculator                             ");
        System.out.println("     You can add, subtract, multiply, or divide two fractions together (+, -, *, /)    ");
        System.out.println("        You can enter the fractions as either a mixed number or improper fraction      ");
        System.out.println(" If using mixed numbers, place an underscore between the whole number and the fraction ");
        System.out.println("Please note that only fractions are accepted, decimals and purely whole numbers are not");
        System.out.println("                                                                                       ");
        System.out.println("                             Example Valid Equations:                                  ");
        System.out.println("                                 • 1/2 * 3_3/4                                         ");
        System.out.println("                                 • 2_3/8 + 9/8                                         ");
        System.out.println("=======================================================================================");
        System.out.println(" ");
        System.out.print("Please enter the fractional operation that that you would like solved: ");

        String desiredCalculation = consoleInput.nextLine();

        while (!isUserInputValid(desiredCalculation)) {
            System.out.print(desiredCalculation + " is not a valid input, please try again: ");
            desiredCalculation = consoleInput.nextLine();
        }

        System.out.println("desiredCalculation: " + desiredCalculation);

        String result = calculateResult(desiredCalculation);
        displayResult(desiredCalculation, result);
    }

    public static boolean isUserInputValid(String desiredCalculation) {
        int numberOfSpaces = 0;
        int numberOfValidOperations = 0;
        int firstSpaceLocation = -1;
        int secondSpaceLocation = -1;

        for (int i = 0; i < desiredCalculation.length(); i++) {
            if (desiredCalculation.charAt((i)) == ' ') {
                numberOfSpaces++;
                if (firstSpaceLocation < 0) {
                    firstSpaceLocation = i;
                }
                else {
                    secondSpaceLocation = i;
                }
            }
            // if the character is either '+', '-', '*', '/' AND has an empty character before and after it:
            else if (desiredCalculation.charAt(i) == '+'  || desiredCalculation.charAt(i) == '-'  || desiredCalculation.charAt(i) == '*' || desiredCalculation.charAt(i) == '/') {
                if (desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ') {
                    numberOfValidOperations++;
                }
            }
        }

        return numberOfSpaces == 2
                && numberOfValidOperations == 1
                && isValidFraction(desiredCalculation.substring(0, firstSpaceLocation))
                && isValidFraction(desiredCalculation.substring(secondSpaceLocation + 1));
    }

    public static boolean isValidFraction(String fraction) {
        System.out.println("In the isValidNumber function");
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
                if (!numbers.containsKey(fraction.charAt(i - 1)) || !numbers.containsKey(fraction.charAt(i + 1))) {
                    return false;
                }
                if (containsUnderscore) {
                    return false;
                }
                containsUnderscore = true;
            }
            else if (fraction.charAt(i) == '/') {
                // if the characters directly before and after the '/' are not numbers:
                if (!numbers.containsKey(fraction.charAt(i - 1)) || !numbers.containsKey(fraction.charAt(i + 1))) {
                    return false;
                }
                if (containsDivideSymbol) {
                    return false;
                }
                containsDivideSymbol = true;
            }
            else if (fraction.charAt(i) == '-') {
                if (i != 0 && fraction.charAt(i - 1) != ' ') {
                    return false;
                }
                if (!numbers.containsKey(fraction.charAt(i + 1))) {
                    return false;
                }
            }
            else if (!numbers.containsKey(fraction.charAt(i))) {
                return false;
            }
        }

        return containsDivideSymbol;
    }

    public static String calculateResult(String desiredCalculation) {
        boolean firstSpaceFound = false;
        char operation = ' ';
        String firstNum = " ";
        String secondNum = " ";

        for (int i = 0; i < desiredCalculation.length(); i++) {
            if (desiredCalculation.charAt((i)) == ' ') {
                if (!firstSpaceFound) {
                    firstNum = desiredCalculation.substring(0, i);
                    firstSpaceFound = true;
                }
                else {
                    secondNum = desiredCalculation.substring(i + 1);
                }
            }
            else if (desiredCalculation.charAt(i) == '+'
                    || desiredCalculation.charAt(i) == '-'
                    || desiredCalculation.charAt(i) == '*'
                    || (desiredCalculation.charAt(i) == '/' && desiredCalculation.charAt(i - 1) == ' ' && desiredCalculation.charAt(i + 1) == ' ')) {
                operation = desiredCalculation.charAt(i);
            }
        }

        String num1 = getImproperFraction(firstNum);
        String num2 = getImproperFraction(secondNum);

        long num1Numerator = 0L;
        long num1Denominator = 0L;
        long num2Numerator = 0L;
        long num2Denominator = 0L;

        for (int x = 0; x < num1.length(); x++) {
            if (num1.charAt(x) == '/') {
                num1Numerator = Integer.parseInt(num1.substring(0, x));
                num1Denominator = Integer.parseInt(num1.substring(x + 1));
            }
        }

        for (int y = 0; y < num2.length(); y++) {
            if (num2.charAt(y) == '/') {
                num2Numerator = Integer.parseInt(num2.substring(0, y));
                num2Denominator = Integer.parseInt(num2.substring(y + 1));
            }
        }
        return performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
    }

    public static String performOperation(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator, char operation) {
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

    public static String add(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        long newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        long newNumerator = firstNumerator * (newDenominator / firstDenominator) + secondNumerator * (newDenominator / secondDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    public static String subtract(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        long newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        long newNumerator = firstNumerator * (newDenominator / firstDenominator) - secondNumerator * (newDenominator / secondDenominator);
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    public static String multiply(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        long newNumerator = firstNumerator * secondNumerator;
        long newDenominator = firstDenominator * secondDenominator;
        return Long.toString(newNumerator) + '/' + Long.toString(newDenominator);
    }

    public static long findLowestCommonMultiple(long firstNum, long secondNum) {
        long lowestCommonMultiple;
        if (firstNum % secondNum == 0) {
            lowestCommonMultiple = firstNum;
            return lowestCommonMultiple;
        }
        if (secondNum % firstNum == 0) {
            lowestCommonMultiple = secondNum;
            return lowestCommonMultiple;
        }

        lowestCommonMultiple = firstNum * secondNum;

        while (lowestCommonMultiple % firstNum == 0 && lowestCommonMultiple % secondNum == 0) {
            lowestCommonMultiple /= 2;
        }
        return lowestCommonMultiple * 2;
    }

    public static String reduce(String fraction) {
        int divideSymbolLocation = -1;

        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '/') {
                divideSymbolLocation = i;
            }
        }

        long numerator = Integer.parseInt(fraction.substring(0, divideSymbolLocation));
        long denominator = Integer.parseInt(fraction.substring(divideSymbolLocation + 1));

        return reducer(numerator, denominator);
    }

    public static String reducer(long numerator, long denominator) {
        if (numerator % denominator == 0) {
            long reduced = numerator / denominator;
            return Long.toString(reduced);
        }

        long smaller = (numerator < denominator) ? numerator : denominator;
        for (int i = 2; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                return reducer(numerator / i,denominator / i);
            }
        }
        return Long.toString(numerator) + '/' + Long.toString(denominator);
    }

    public static String getImproperFraction(String fraction) {
        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '_') {
                return mixedToImproperFraction(fraction);
            }
        }
        return fraction;
    }

    public static String mixedToImproperFraction(String mixed) {
        int underscoreLocation = -1, divideSymbolLocation = -1;

        for (int i = 0; i < mixed.length(); i++) {
            if (mixed.charAt(i) == '_') {
                underscoreLocation = i;
            }
            if (mixed.charAt(i) == '/') {
                divideSymbolLocation = i;
            }
        }

        long denominator = Integer.parseInt(mixed.substring(divideSymbolLocation + 1));
        long wholeNumber = Integer.parseInt(mixed.substring(0, underscoreLocation));
        long currentNumerator = Integer.parseInt(mixed.substring(underscoreLocation + 1, divideSymbolLocation));
        long newNumerator = wholeNumber * denominator + currentNumerator;
        return Long.toString(newNumerator)+ '/' + Long.toString(denominator);
    }

    public static String calculateMixedFraction(String fraction) {
        boolean containsDivideSymbol = false;
        long numerator = 0L;
        long denominator = 0L;

        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '/') {
                numerator = Integer.parseInt(fraction.substring(0, i));
                denominator = Integer.parseInt(fraction.substring(i + 1));
                containsDivideSymbol = true;
            }
        }

        if (!containsDivideSymbol || numerator < denominator) {
            return fraction;
        }

        long wholeNumber = numerator / denominator;
        long newNumerator = numerator - (wholeNumber * denominator);
        return Long.toString(wholeNumber) + '_' + Long.toString(newNumerator) + '/' + Long.toString(denominator);
    }

    public static void displayResult(String desiredCalculation, String result) {
        System.out.println(" ");
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
        System.out.println(desiredCalculation + " = " + result);
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
        runNewCalculation();
    }

    public static void runNewCalculation() {
        System.out.println(" ");
        System.out.print("Do you want to run another calculation? (yes/no): ");
        String anotherOne = consoleInput.nextLine();
        if (anotherOne.toLowerCase().equals("yes")) {
            gatherCalculationInfo();
        }
        else {
            System.out.println("Okay, bye!");
        }
    }

    public static void main(String[] args) {
        gatherCalculationInfo();
    }
}

/////////////////////////////
////////// TESTS ////////////
/////////////////////////////

/*
Valid input tests:
• input is a mixed number with more than one underscore (110__2/3)
• input has an extra space in the middle(1 10_2/3)
• input is not a fraction (0.44)
• input does not contain '/'
• input has more than one divide symbol (13_1/3342/3)
• input contains letters (hello)
• input contains other symbols (1$4/4)


• Input contains one number that is just a whole number (5 * 5)
*TODO* Negative fractions are currently returning an error
*/