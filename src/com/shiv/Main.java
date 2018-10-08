package com.shiv;

import java.util.HashMap;
import java.util.Scanner;

import static com.shiv.Calculation.*;

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

    private static boolean isUserInputValid(String desiredCalculation) {
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

    private static void displayResult(String desiredCalculation, String result) {
        System.out.println(" ");
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
        System.out.println(desiredCalculation + " = " + result);
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
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
*TODO* Negative fractions are currently returning an error
*/