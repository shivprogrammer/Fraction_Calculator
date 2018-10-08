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

    //TODO -- Negative fractions are currently returning an error
    //TODO -- Throw exception for massive number inputs
    //TODO -- Double check the full validity of the reduce function

    ///////////////////////
    // VALID INPUT TESTS //
    ///////////////////////
    @Test
    public void isUserInputValid_inputIsNull_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid(""), false);
    }
    @Test
    public void isUserInputValid_inputContainsLetters_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("a1/2 + 3/2b"), false);
    }
    @Test
    public void isUserInputValid_inputIsNotAFraction_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("1 + 3/2"), false);
    }
    @Test
    public void isUserInputValid_inputIsADecimal_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("13/14 + 3.5"), false);
    }
    @Test
    public void isUserInputValid_inputHasExtraSpaces_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("1 10_2/3 * 6/8"), false);
    }
    @Test
    public void isUserInputValid_inputHasOtherSymbols_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("10_2/3 * 1$4/4"), false);
    }
    @Test
    public void isUserInputValid_inputHasInvalidOperationSymbol_False() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("10_2/3 x 4/4"), false);
    }
    @Test
    public void isUserInputValid_inputContainsMassiveNumbers_Success() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("9223372036854775807/1212 / 113231414123123145432432342/12"), true);
    }
    @Test
    public void isUserInputValid_inputContainsNegativeNumbers_ThrowException() {
        Assert.assertEquals(CheckValidInput.isUserInputValid("-4/3 * 7/12"), false);
    }
}




