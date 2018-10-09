package com.shiv.test;

import com.shiv.main.Calculation;
import org.junit.Assert;
import org.junit.Test;

public class CalculationTest extends Calculation {
    ///////////////
    // ADD TESTS //
    ///////////////
//    @Test
//    public void add_simpleValues_Success() {
//        Assert.assertEquals(calculateResult("1/10 + 2/10"), "3/10");
//    }
//    @Test
//    public void add_inputContainsNegativeFraction_Success() {
//        Assert.assertEquals(calculateResult("-1/10 + 2/10"), "1/10");
//    }
//    @Test
//    public void add_resultHasNewDenominator_Success() {
//        Assert.assertEquals(calculateResult("1/10 + 4/10"), "1/2");
//    }
//    @Test
//    public void add_numeratorOfSecondFractionIsZero_Success() {
//        Assert.assertEquals(calculateResult("1/3 + 0/3"), "1/3");
//    }
//    @Test
//    public void add_resultWasNotReduced_Incorrect() {
//        Assert.assertNotEquals(calculateResult("1/10 + 4/10"), "5/10");
//    }
//    @Test
//    public void add_resultIsMixedNumber_Success() {
//        Assert.assertEquals(calculateResult("2/3 + 2/3"), "1_1/3");
//    }
//    @Test
//    public void add_resultShouldHaveBeenMixedNumber_Incorrect() {
//        Assert.assertNotEquals(calculateResult("2/3 + 2/3"), "4/3");
//    }
//    @Test
//    public void add_resultIsWholeNumber_Success() {
//        Assert.assertEquals(calculateResult("1/3 + 2/3"), "1");
//    }
//    @Test
//    public void add_resultShouldBeWholeNumberNotFraction_Incorrect() {
//        Assert.assertNotEquals(calculateResult("1/3 + 2/3"), "3/3");
//    }
//    @Test
//    public void add_inputHasMixedAndImproperFraction_Success() {
//        Assert.assertNotEquals(calculateResult("10_2/3 * 53/5"), "3/3");
//    }

    ////////////////////
    // SUBTRACT TESTS //
    ////////////////////
//    @Test
//    public void subtract_resultIsWholeNumber_Success() {
//        Assert.assertEquals(calculateResult("1/3 - 1/3"), "0");
//    }
//    @Test
//    public void subtract_numeratorOfSecondFractionIsZero_Success() {
//        Assert.assertEquals(calculateResult("1/3 - 0/3"), "1/3");
//    }
//    @Test
//    public void subtract_numeratorOfFirstFractionIsZero_Success() {
//        Assert.assertEquals(calculateResult("0/5 - 7/12"), "-7/12");
//    }
//    @Test
//    public void subtract_resultIsNegative_Success() {
//        Assert.assertEquals(calculateResult("1/3 - 2/3"), "-1/3");
//    }
//    @Test
//    public void subtract_firstFractionIsNegativeAndResultIsNegativeInt_Success() {
//        Assert.assertEquals(calculateResult("-1/3 - 2/3"), "-1");
//    }

    ////////////////////
    // MULTIPLY TESTS //
    ////////////////////
//    @Test
//    public void multiply_simpleValues_Success() {
//        Assert.assertEquals(calculateResult("1/3 * 1/3"), "1/9");
//    }
//    @Test
//    public void multiply_numeratorOfSecondFractionIsZero_Success() {
//        Assert.assertEquals(calculateResult("1/3 * 0/3"), "0");
//    }
    @Test
    public void multiply_secondFractionIsNegative_Success() {
        Assert.assertEquals(calculateResult("1/2 * -1/2"), "-1/4");
    }
    @Test
    public void multiply_bothFractionsAreNegative_Success() {
        Assert.assertEquals(calculateResult("-1/2 * -1/2"), "1/4");
    }
//    @Test
//    public void multiply_denominatorIsZero_False() {
//        Assert.assertEquals(calculateResult("10_2/3 * 4/0"), "Your fraction cannot have a denominator of 0");
//    }

    //////////////////
    // DIVIDE TESTS //
    //////////////////
//    @Test
//    public void divide_simpleValues_Success() {
//        Assert.assertEquals(calculateResult("7/8 / 7/5"), "5/8");
//    }
//    @Test
//    public void divide_denominatorIsZero_False() {
//        Assert.assertEquals(calculateResult("10_2/3 / 4/0"), "Your fraction cannot have a denominator of 0");
//    }
//    @Test
//    public void divide_numeratorOfSecondFractionIsZero_False() {
//        Assert.assertEquals(calculateResult("10_2/3 / 0/4"), "You cannot divide by a 0 fraction");
//    }
    @Test
    public void divide_secondFractionIsNegative_Success() {
        Assert.assertEquals(calculateResult("8/9 / -8/9"), "-1");
    }
}