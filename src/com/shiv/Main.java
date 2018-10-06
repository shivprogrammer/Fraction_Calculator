package com.shiv;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner consoleInput = new Scanner(System.in);

    public static void initiateCalculation() {
        System.out.println(" ");
        System.out.println("Welcome to the Fraction Calculator");
        System.out.println("Please enter your first number as either a mixed number or improper fraction.");
        System.out.print("If using a mixed variable, put an underscore between the whole number and the fraction (ex: 2_2/3): ");
        String firstNum = consoleInput.nextLine();
        while (!isValidNumber(firstNum)) {
            System.out.print("You have entered an invalid fraction, please try again: ");
            firstNum = consoleInput.nextLine();
        }
        System.out.println("Your first number is: " + firstNum);
        System.out.println(" ");

        System.out.print("Great, now please enter your second number in the same fashion: ");
        String secondNum = consoleInput.nextLine();
        while (!isValidNumber(secondNum)) {
            System.out.print("You have entered an invalid fraction, please try again: ");
            secondNum = consoleInput.nextLine();
        }
        System.out.println("Your second number is: " + secondNum);
        System.out.println(" ");

        System.out.print("Great, now enter the operation you would like done to the two numbers [add, subtract, multiply, divide]: ");
        String operation = consoleInput.nextLine().toLowerCase();
        while (!isValidOperation(operation)) {
            System.out.print("You have entered an invalid operation, please try again: ");
            operation = consoleInput.nextLine().toLowerCase();
        }
        System.out.println("The operation you want done between the two numbers is: " + operation);
        System.out.println(" ");

        System.out.println("=========================================");
        String result = calculateResult(firstNum, secondNum, operation);
        System.out.println("The result of " + firstNum + " " + operation + " with " + secondNum + " is: " + result);
        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Do you want to run another calculation?: ");
        String anotherOne = consoleInput.nextLine();
        if (anotherOne.toLowerCase().equals("yes")) {
            initiateCalculation();
        }
        else {
            System.out.println("Okay, bye!");
        }
    }

    public static boolean isValidNumber(String number) {
        HashMap<Character, Integer> numbers = new HashMap<Character, Integer>();
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

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '_') {
                if (!numbers.containsKey(number.charAt(i - 1)) || !numbers.containsKey(number.charAt(i - 1))) {
                    return false;
                }
                if (containsUnderscore == true) {
                    return false;
                }
                containsUnderscore = true;
            }
            else if (number.charAt(i) == '/') {
                if (!numbers.containsKey(number.charAt(i - 1)) || !numbers.containsKey(number.charAt(i - 1))) {
                    return false;
                }
                if (containsDivideSymbol == true) {
                    return false;
                }
                containsDivideSymbol = true;
            }
            else if (!numbers.containsKey(number.charAt(i))) {
                return false;
            }
        }

        return containsDivideSymbol;
    }

    public static boolean isValidOperation(String operation) {
        return operation.equals("add") || operation.equals("subtract") || operation.equals("multiply") || operation.equals("divide");
    }

    public static String calculateResult(String firstNum, String secondNum, String operation) {
        String num1 = calculateImproperFraction(firstNum);
        String num2 = calculateImproperFraction(secondNum);
        int num1Numerator = 0;
        int num1Denominator = 0;
        int num2Numerator = 0;
        int num2Denominator = 0;

        for (int x = 0; x < num1.length(); x++) {
            if (num1.charAt(x) == '/') {
                num1Numerator = Integer.parseInt(num1.substring(0, x));
                num1Denominator = Integer.parseInt(num1.substring(x + 1, num1.length()));
            }
        }

        for (int y = 0; y < num2.length(); y++) {
            if (num2.charAt(y) == '/') {
                num2Numerator = Integer.parseInt(num2.substring(0, y));
                num2Denominator = Integer.parseInt(num2.substring(y + 1, num2.length()));
            }
        }

        return performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
//        return resultsMessage(firstNum, secondNum, operation, result);
    }

    public static String performOperation(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator, String operation) {
        if (operation.equals("add")) {
            String result = add(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
            return reduce(result);
        }
        else if (operation.equals("subtract")) {
            String result = subtract(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
            return reduce(result);
        }
        else if (operation.equals("multiply")) {
            String result = multiply(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
            return reduce(result);
        }
        // Utilizing a trick of fractional division -- dividing one fraction by another is the same as multiplying the first fraction by the inverse of the second fraction
        else if (operation.equals("divide")) {
            String result = multiply(firstNumerator, firstDenominator, secondDenominator, secondNumerator);
            return reduce(result);
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
        int newNumerator = firstNumerator * (newDenominator / firstDenominator) + secondNumerator * (newDenominator / secondDenominator);
        String result = Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
        return result;
    }

    public static String subtract(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
        int newDenominator = findLowestCommonMultiple(firstDenominator, secondDenominator);
        int newNumerator = firstNumerator * (newDenominator / firstDenominator) - secondNumerator * (newDenominator / secondDenominator);
        String result = Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
        return result;
    }

    public static int findLowestCommonMultiple(int firstNum, int secondNum) {
        int lowestCommonMultiple;
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
        for (int i = 2; i <= smaller; i++) {
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
        return Integer.toString(newNumerator)+ '/' + Integer.toString(denominator);
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
Valid input tests:
• input is a mixed number with more than one underscore (110__2/3)
• input has an extra space in the middle(1 10_2/3)
• input is not a fraction (0.44)
• input does not contain '/'
• input has more than one divide symbol (13_1/3342/3)
• input contains letters (hello)
• input contains other symbols (1$4/4)
*TODO* Handle negative numbers
*/