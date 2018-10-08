package com.shiv.test;

import com.shiv.main.Conversions;
import org.junit.Assert;
import org.junit.Test;

public class ConversionsTest extends Conversions {
    @Test
    public void getImproperFraction_inputIsSimpleFraction_Success() {
        Assert.assertEquals(getImproperFraction("1/4"), "1/4");
    }
    @Test
    public void getImproperFraction_inputIsAlreadyImproper_Success() {
        Assert.assertEquals(getImproperFraction("17/5"), "17/5");
    }
    @Test
    public void getImproperFraction_inputIsMixedNumber_Success() {
        Assert.assertEquals(getImproperFraction("10_2/3"), "32/3");
    }
}