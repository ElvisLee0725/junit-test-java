package com.elvislee.isbntools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {
    Calculator myCalculator = new Calculator();
    @Test
    public void returningCorrectSumWhenInputsAreInteger() {
        int result = myCalculator.sum(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void returningCorrectSumWhenInputsAreDouble() {
        double result = myCalculator.sum(2.55646, 3.8234);
        assertEquals(6.37986, result, 0.0002);
    }

    @Test(expected = NumberFormatException.class)
    public void throwErrorWhenInputsAreNotNumber() {

    }
}
