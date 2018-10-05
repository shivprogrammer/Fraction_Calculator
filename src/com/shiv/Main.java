package com.shiv;

import java.util.Scanner;

public class Main {
    private static Scanner consoleInput = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void initiateCalculation() {
        clearScreen();

        System.out.println("Welcome to the Fraction Calculator");
        System.out.println("Please enter your first number as either a mixed number or improper fraction.");
        System.out.print("If you are entering a mixed variable, please put a space between the whole number and the fraction: ");
        String firstNum = consoleInput.nextLine();
        System.out.println("Your first number is: " + firstNum);
        System.out.println(" ");

        System.out.print("Great, now please enter your second number in the same fashion: ");
        String secondNum = consoleInput.nextLine();
        System.out.println("Your second number is: " + secondNum);
        System.out.println(" ");

        System.out.print("Great, now enter the operation you would like done to the two numbers [add, subtract, multiply, divide]: ");
        String operation = consoleInput.nextLine();
        System.out.println("The operation you want done between the two numbers is: " + operation);
        System.out.println(" ");

//        System.out.print("Great, would you like your answer as a mixed fraction or an improper fraction? ");
//        String mixedOrImproper = consoleInput.nextLine();
//        System.out.println("Cool, you want your result as a " + mixedOrImproper + " fraction");

        String result = calculateResult(firstNum, secondNum, operation);

        System.out.println("The result of " + firstNum + " " + operation + " with " + secondNum + " in the form of an improper fraction is: " + result);
    }

    public static String calculateResult(String firstNum, String secondNum, String operation) {
        System.out.println("operation: " + operation);
        String num1 = calculateImproperFraction(firstNum);
        String num2 = calculateImproperFraction(secondNum);
        int num1Numerator = 0;
        int num1Denominator = 0;
        int num2Numerator = 0;
        int num2Denominator = 0;

        for (int x = 0; x < num1.length(); x++) {
            if (num1.charAt(x) == '/') {
                num1Numerator = Integer.parseInt(num1.substring(0, x));
                System.out.println("num1Numerator: " + num1Numerator);
                num1Denominator = Integer.parseInt(num1.substring(x + 1, num1.length()));
                System.out.println("num1Denominator: " + num1Denominator);

            }
        }

        for (int y = 0; y < num2.length(); y++) {
            if (num2.charAt(y) == '/') {
                num2Numerator = Integer.parseInt(num2.substring(0, y));
                System.out.println("num2Numerator: " + num2Numerator);
                num2Denominator = Integer.parseInt(num2.substring(y + 1, num2.length()));
                System.out.println("num2Denominator: " + num2Denominator);

            }
        }

        String result = performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
        return result;

//        return resultsMessage(firstNum, secondNum, operation, result);
    }

    public static String performOperation(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator, String operation) {
        if (operation.equals("add")) {
            return add(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
        }
        else if (operation.equals("subtract")) {
            return subtract(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
        }
        else if (operation.equals("multiply")) {
            String result = multiply(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
            return reduce(result);
        }
        // Utilizing a trick of fractional division -- dividing one fraction by another is the same as multiplying the first fraction by the inverse of the second fraction
        else if (operation.equals("divide")) {
            return multiply(firstNumerator, firstDenominator, secondDenominator, secondNumerator);
        }
        return "";
    }

    public static String multiply(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
        int newNumerator = firstNumerator * secondNumerator;
        int newDenominator = firstDenominator * secondDenominator;
        String result = Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
        return result;
    }

    public static String add(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
        int newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        System.out.println("newDenominator: " + newDenominator);
        int newNumerator = firstNumerator * (newDenominator / firstDenominator) + secondNumerator * (newDenominator / secondDenominator);
        System.out.println("newNumerator: " + newNumerator);
        String result = Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
        return result;
    }

    public static String subtract(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
        int newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        System.out.println("newDenominator: " + newDenominator);
        int newNumerator = firstNumerator * (newDenominator / firstDenominator) - secondNumerator * (newDenominator / secondDenominator);
        System.out.println("newNumerator: " + newNumerator);
        String result = Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
        return result;
    }

    public static int findLowestCommonMultiple(int firstNum, int secondNum) {
        int lowestCommonMultiple = firstNum * secondNum;

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

        int numerator = Integer.parseInt(fraction.substring(0, divideSymbolLocation));
        int denominator = Integer.parseInt(fraction.substring(divideSymbolLocation + 1, fraction.length()));

        return reducer(numerator, denominator);
    }

    public static String reducer(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            int reduced = numerator / denominator;
            return Integer.toString(reduced);
        }

        int smaller = (numerator < denominator) ? numerator : denominator;
        for (int i = 2; i < smaller / 2; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                return reducer(numerator / i,denominator / i);
            }
        }
        return Integer.toString(numerator) + '/' + Integer.toString(denominator);
    }

    public static String calculateImproperFraction(String fraction) {
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

        int denominator = Integer.parseInt(mixed.substring(divideSymbolLocation + 1, mixed.length()));
        int wholeNumber = Integer.parseInt(mixed.substring(0, underscoreLocation));
        int currentNumerator = Integer.parseInt(mixed.substring(underscoreLocation + 1, divideSymbolLocation));
        int newNumerator = wholeNumber * denominator + currentNumerator;
        String result = Integer.toString(newNumerator)+ '/' + Integer.toString(denominator);
        return result;
    }

//    public static String calculateMixedFraction(String fraction) {
//        return "";
//    }

    public static void main(String[] args) {
        initiateCalculation();
    }
}


/////////////////////////////
////////// TESTS ////////////
/////////////////////////////

/*
Potential tests:
• input is a mixed number with more than one underscore (110__2/3)
• input has an extra space in the middle(1 10_2/3)
• input is not a fraction (0.44)
        -> if input does not have '/'
*/