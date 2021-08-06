package com.elvislee.isbntools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StockManagementTest {
    @Test
    public void canGetACorrectLocatorCode() {
        String isbn = "0140177396";
        StockManager stockManager = new StockManager();
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);

    }
}
