package com.shiv;

import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String calculateImproperFraction(String fraction) {

    }

    public static String multiply(String num1, String num2) {
        
    }

    public static void main(String[] args) {
        clearScreen();

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Fraction Calculator");
        System.out.println("Please enter your first number as either a mixed number or improper fraction. If you are entering a mixed variable, please put a space between the whole number and the fraction");

        String firstNum = in.nextLine();

        System.out.println("Great, now please enter your second number in the same fashion");

        String secondNum = in.nextLine();

        System.out.println("Great, now enter the operation you would like done to the two numbers [add, subtract, multiply, divide");


    }
}
