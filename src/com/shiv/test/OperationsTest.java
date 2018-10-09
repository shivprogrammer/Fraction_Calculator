package com.shiv.test;

import com.shiv.main.Operations;
import org.junit.Assert;
import org.junit.Test;

public class OperationsTest extends Operations {
    //////////////////
    // REDUCE TESTS //
    //////////////////
    @Test
    public void reduce_fractionCanBeReduced_Success() {
        Assert.assertEquals(reduce("3/21"), "1/7");
    }
    @Test
    public void reduce_fractionCannotBeReduced_Success() {
        Assert.assertEquals(reduce("7/10"), "7/10");
    }
    @Test
    public void reduce_negativeFraction_Success() {
        Assert.assertEquals(reduce("-35/60"), "-7/12");
    }
}