package com.shiv;

import java.util.Scanner;

public class Main {
    private static Scanner consoleInput = new Scanner(System.in);

//    public Main() {
//        initiateCalculation();
//    }

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
//        if (checkValidOperation(operation)) {
        System.out.println("The operation you want done between the two numbers is: " + operation);
        System.out.println(" ");
//        }

//        System.out.print("Great, would you like your answer as a mixed fraction or an improper fraction? ");
//        String mixedOrImproper = in.nextLine();
//        System.out.println("Cool, you want your result as a " + mixedOrImproper + " fraction");

        String result = calculateResult(firstNum, secondNum, operation);

        System.out.println("The result of " + firstNum + " " + operation + " with " + secondNum + " is: " + result);
    }

    public static String calculateResult(String firstNum, String secondNum, String operation) {
        System.out.println("operation: " + operation);
        String num1 = calculateImproperFraction(firstNum);
        String num2 = calculateImproperFraction(secondNum);
        int num1Numerator = 0;
        int num1Denominator = 0;
        int num2Numerator = 0;
        int num2Denominator = 0;
//        String newNumber = "";

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

//        if (operation == "multiply") {
//            System.out.println("We are in the multiply function");
//            newNumber = multiply(num1Numerator, num1Denominator, num2Numerator, num2Denominator);
//            System.out.println("Your result is: " + newNumber);
//        }

        String newNumber = performOperation(num1Numerator, num1Denominator, num2Numerator, num2Denominator, operation);
        System.out.println("newNumber: " + newNumber);
        return newNumber;
    }

    public static String performOperation(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator, String operation) {
        if (operation == "add") {

        }
        else if (operation == "subtract") {

        }
        else if (operation.equals("multiply")) {
            System.out.println("We are in the multiply function");
            String newNumber = multiply(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
            return newNumber;
        }
        else if (operation == "divide") {

        }
        return "";
    }

    public static String multiply(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
        int newNumerator = firstNumerator * secondNumerator;
        System.out.println("newNumerator: " + newNumerator);
        int newDenominator = firstDenominator * secondDenominator;
        System.out.println("newDenominator: " + newDenominator);
        String newNumber = Integer.toString(newNumerator)+ '/' + Integer.toString(newDenominator);
        System.out.println("newNumber: " + newNumber);
        return newNumber;
    }

//    public static String reduce(String firstNum, String secondNum) {
//
//    }

    public static String calculateImproperFraction(String fraction) {
        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '_') {
                // perform some other function
            }
        }
        return fraction;
    }

//    public static String calculateMixedFraction(String fraction) {
//        return "";
//    }

//    public static String mixedToImproper(String mixed) {
//        return "";
//    }

//    public static String add(String num1, String num2) {
//        return "";
//    }

//    public static String subtract(String num1, String num2) {
//        return "";
//    }

//    public static String divide(String num1, String num2) {
//        return "";
//    }

    public static void main(String[] args) {
        initiateCalculation();
//        calculateResult("111/8", "22/3", "multiply");
//        new Main();
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