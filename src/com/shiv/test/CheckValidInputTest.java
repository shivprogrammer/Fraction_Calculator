package com.shiv.test;

import com.shiv.main.CheckValidInput;
import org.junit.Assert;
import org.junit.Test;

public class CheckValidInputTest extends CheckValidInput {
    //////////////////////////
    // INPUT VALIDITY TESTS //
    //////////////////////////
    @Test
    public void isUserInputValid_inputIsNull_False() {
        Assert.assertEquals(isUserInputValid(""), false);
    }
    @Test
    public void isUserInputValid_inputContainsLetters_False() {
        Assert.assertEquals(isUserInputValid("a1/2 + 3/2b"), false);
    }
    @Test
    public void isUserInputValid_inputContainsMixedAndImproperFraction_Success() {
        Assert.assertEquals(isUserInputValid("10_2/3 * 53/5"), true);
    }
    @Test
    public void isUserInputValid_inputIsNotAFraction_False() {
        Assert.assertEquals(isUserInputValid("1 + 3/2"), false);
    }
    @Test
    public void isUserInputValid_inputIsADecimal_False() {
        Assert.assertEquals(isUserInputValid("13/14 + 3.5"), false);
    }
    @Test
    public void isUserInputValid_inputHasExtraSpaces_False() {
        Assert.assertEquals(isUserInputValid("1 10_2/3 * 6/8"), false);
    }
    @Test
    public void isUserInputValid_inputHasOtherSymbols_False() {
        Assert.assertEquals(isUserInputValid("10_2/3 * 1$4/4"), false);
    }
    @Test
    public void isUserInputValid_inputHasInvalidOperationSymbol_False() {
        Assert.assertEquals(isUserInputValid("10_2/3 x 4/4"), false);
    }
    @Test
    public void isUserInputValid_denominatorIsZero_False() {
        Assert.assertEquals(isUserInputValid("10_2/3 * 4/0"), false);
    }
    @Test
    public void isUserInputValid_denominatorIsMultipleZeros_False() {
        Assert.assertEquals(isUserInputValid("4/00000 * 10_2/3"), false);
    }
    @Test
    public void isUserInputValid_inputContainsNumbersThatAreTooLarge_False() {
        Assert.assertEquals(isUserInputValid("9223372036854775807/1212 / 113231414123123145432432342/12"), false);
    }

//    @Test
//    public void isUserInputValid_inputContainsNegativeNumbers_Success() {
//        Assert.assertEquals(isUserInputValid("-4/3 * 7/12"), true);
//    }
}