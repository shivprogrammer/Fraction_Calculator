package com.shiv;

import org.junit.Assert;
import org.junit.Test;
//import java.io.*;

//import static org.junit.jupiter.api.Assertions.*;

public class FractionCalculatorTest extends FractionCalculator {
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//    private final PrintStream originalErr = System.err;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setErr(originalErr);
//    }

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

    ///////////////////////
    // VALID INPUT TESTS //
    ///////////////////////
    @Test
    public void isUserInputValid_inputIsNull_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid(""), false);
    }
    @Test
    public void isUserInputValid_inputContainsALetter_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("a1/2 + 3/2"), false);
    }

    ///////////////
    // ADD TESTS //
    ///////////////
    @Test
    public void add_simpleValues_Success() {
        Assert.assertEquals(Calculation.calculateResult("1/10 + 2/10"), "3/10");
    }
    @Test
    public void add_resultHasNewDenominator_Success() {
        Assert.assertEquals(Calculation.calculateResult("1/10 + 4/10"), "1/2");
    }
    @Test
    public void add_resultWasNotReduced_Incorrect() {
        Assert.assertNotEquals(Calculation.calculateResult("1/10 + 4/10"), "5/10");
    }
    @Test
    public void add_resultIsMixedNumber_Success() {
        Assert.assertEquals(Calculation.calculateResult("2/3 + 2/3"), "1_1/3");
    }
    @Test
    public void add_resultShouldHaveBeenMixedNumber_Incorrect() {
        Assert.assertNotEquals(Calculation.calculateResult("2/3 + 2/3"), "4/3");
    }
    @Test
    public void add_resultIsWholeNumber_Success() {
        Assert.assertEquals(Calculation.calculateResult("1/3 + 2/3"), "1");
    }
    @Test
    public void add_resultShouldBeWholeNumberNotFraction_Incorrect() {
        Assert.assertNotEquals(Calculation.calculateResult("1/3 + 2/3"), "3/3");
    }

    ////////////////////
    // SUBTRACT TESTS //
    ////////////////////
    @Test
    public void subtract_resultIsWholeNumber_Success() {
        Assert.assertEquals(Calculation.calculateResult("1/3 - 1/3"), "0");
    }

    ////////////////////
    // MULTIPLY TESTS //
    ////////////////////
    @Test
    public void multiply_simpleValues_Success() {
        Assert.assertEquals(Calculation.calculateResult("1/3 * 1/3"), "1/9");
    }

    //////////////////
    // DIVIDE TESTS //
    //////////////////
    @Test
    public void divide_simpleValues_Success() {
        Assert.assertEquals(Calculation.calculateResult("7/8 / 7/5"), "5/8");
    }

    //////////////////
    // REDUCE TESTS //
    //////////////////
    @Test
    public void reduce_fractionCanBeReduced_Success() {
        Assert.assertEquals(Operations.reduce("3/21"), "1/7");
    }
    @Test
    public void reduce_fractionCannotBeReduced_Success() {
        Assert.assertEquals(Operations.reduce("7/10"), "7/10");
    }
}




