package com.shiv;

import org.junit.Assert;
import org.junit.Test;

public class OperationsTest extends Operations{
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