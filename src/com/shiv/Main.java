package com.shiv;

import java.util.Scanner;

public class Main {

    public static void gatherInformation() {
        clearScreen();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Fraction Calculator");
        System.out.println("Please enter your first number as either a mixed number or improper fraction. If you are entering a mixed variable, please put a space between the whole number and the fraction");
        String firstNum = in.nextLine();
        System.out.println("Your first number is: " + firstNum);
        System.out.println(" ");

        System.out.println("Great, now please enter your second number in the same fashion");
        String secondNum = in.nextLine();
        System.out.println("Your second number is: " + secondNum);
        System.out.println(" ");

        System.out.println("Great, now enter the operation you would like done to the two numbers [add, subtract, multiply, divide");
        String operation = in.nextLine();
//        if (checkValidOperation(operation)) {
        System.out.println("The operation you want done between the two numbers is: " + operation);
        System.out.println(" ");
//        }

        System.out.println("Great, would you like your answer as a mixed fraction or an improper fraction?");
        String mixedOrImproper = in.nextLine();
        System.out.println("You want your result as a " + mixedOrImproper + " fraction");

        calculateResult(firstNum, secondNum, operation);
    }

    public static String calculateResult(String firstNum, String secondNum, String operation) {
        String num1 = calculateImproperFraction(firstNum);
        String num2 = calculateImproperFraction(secondNum);

        return "";
    }

    public static String calculateImproperFraction(String fraction) {
        for (int i = 0; i < fraction.length; i++) {
            if ()
        }

        int numerator;
        int denominator;

        return "";
    }

    public static String calculateMixecFraction(String fraction) {
        
    }

    public static String mixedToImproper(String mixed) {

    }

    public static String add(String num1, String num2) {
        return "";
    }

    public static String subtract(String num1, String num2) {
        return "";
    }

    public static String multiply(String num1, String num2) {
        return "";
    }

    public static String divide(String num1, String num2) {
        return "";
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        gatherInformation();
    }
}

/*
Potential tests:
• input is a mixed number with more than one underscore (110__2/3)
• input has an extra space in the middle(1 10_2/3)
• input is not a fraction (0.44)
        -> if input does not have '/'
 */