package com.shiv;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;

// import static org.junit.jupiter.api.Assertions.*;

public class FractionCalculatorTest extends Calculation {
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

    @Test
    public void test1() {
//        FractionCalculator fracCalc = new FractionCalculator();

        Assert.assertEquals(Calculation.calculateResult("1/3 * 1/3"), "1/9");
    }

//    public static void main(String[] args) {
//        test1();
//    }
}




