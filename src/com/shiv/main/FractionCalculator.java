package com.shiv.main;

import java.util.Scanner;

public class FractionCalculator {
    private static Scanner consoleInput = new Scanner(System.in);

    static void gatherCalculationInfo() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=======================================================================================");
        System.out.println("                        Welcome to the Fraction Calculator                             ");
        System.out.println("                        ----------------------------------                             ");
        System.out.println(" ");
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
        System.out.println("Please enter the fractional operation that that you would like solved: ");

        String desiredCalculation = consoleInput.nextLine();

        while (!CheckValidInput.isUserInputValid(desiredCalculation)) {
            desiredCalculation = consoleInput.nextLine();
        }

        displayResult(desiredCalculation, CheckValidInput.finalResult);
    }

    static void displayResult(String desiredCalculation, String result) {
        System.out.println(" ");
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
        System.out.println("     " + desiredCalculation + " = " + result);
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
        runNewCalculation();
    }

    private static void runNewCalculation() {
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