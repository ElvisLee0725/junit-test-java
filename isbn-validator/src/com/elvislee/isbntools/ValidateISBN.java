package com.elvislee.isbntools;

public class ValidateISBN {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbnNumber) {
        int isbnLength = isbnNumber.length();

        if(isbnLength == SHORT_ISBN_LENGTH) {
            return isValidShortISBN(isbnNumber);
        }
        else if(isbnLength == LONG_ISBN_LENGTH){
            return isValidLongISBN(isbnNumber);
        }

        throw new NumberFormatException("ISBN number must be 10 or 13 digits");
    }

    public boolean isValidShortISBN(String isbnNumber) {
        int total = 0;
        for(int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if(!Character.isDigit(isbnNumber.charAt(i))) {
                if(i != SHORT_ISBN_LENGTH - 1 || isbnNumber.charAt(i) != 'X') {
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
                }
                else {
                    // If the last digit is X, just add 10 to total
                    total += 10;
                }
            }
            else {
                total += (isbnNumber.charAt(i) - '0') * (SHORT_ISBN_LENGTH - i);
            }
        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }


    public boolean isValidLongISBN(String isbnNumber) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbnNumber.charAt(i))) {
                if (i != LONG_ISBN_LENGTH - 1 || isbnNumber.charAt(i) != 'X') {
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
                } else {
                    // If the last digit is X, just add 10 to total
                    total += isbnNumber.charAt(i) - '0';
                }
            } else {
                if (i % 2 == 0) {
                    total += isbnNumber.charAt(i) - '0';
                } else {
                    total += (isbnNumber.charAt(i) - '0') * 3;
                }
            }
        }
        return total % LONG_ISBN_MULTIPLIER == 0;
    }
}
