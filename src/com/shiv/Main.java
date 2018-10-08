package com.shiv;

import java.util.Scanner;

import static com.shiv.Calculation.*;
import static com.shiv.CheckValidInput.*;

public class Main {
    private static Scanner consoleInput = new Scanner(System.in);

    private static void gatherCalculationInfo() {
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

        String result = calculateResult(desiredCalculation);
        displayResult(desiredCalculation, result);
    }

    private static void displayResult(String desiredCalculation, String result) {
        System.out.println(" ");
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
        System.out.println(desiredCalculation + " = " + result);
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
TODO -- Negative fractions are currently returning an error
TODO -- Double check the full validity of the reduce function
*/