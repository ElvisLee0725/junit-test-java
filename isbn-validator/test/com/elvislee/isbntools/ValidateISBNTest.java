package com.elvislee.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {
    @Test
    public void checkValid10DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);

        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void checkInValid10DigitsISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkValid13DigitsISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue("first value", result);

        result = validator.checkISBN("9781853267338");
        assertTrue("second value", result);
    }

    @Test
    public void checkInValid13DigitsISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260088");
        assertFalse(result);
    }

    @Test
    public void tenDigitsISBNNumbersEndingInXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void tenDigitsISBNNumbersEndingInXButInValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000031X");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("140449117");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericInISBNAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("abcdeghijf");
    }
}
