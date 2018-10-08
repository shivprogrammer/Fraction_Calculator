package com.shiv;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static com.shiv.Calculation.*;

//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

class CalculationTest extends Calculation {

//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }

    @Test
    void calculateResult() {
        assertEquals(calculateResult("1/2", "1/2", '+'), "1");
    }
}