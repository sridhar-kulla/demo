package com.test.library.model;

import com.test.library.exception.BadValueException;

public class BookFiction extends Book {
    private double lateFee;

    public BookFiction(long isbn, String title, String author) {
        super(isbn, title, author);
    }

    public double calculateLateFee(int numDaysLate) throws BadValueException {
        if(numDaysLate<0){
            throw new BadValueException();
        }
        lateFee=(numDaysLate/2)*0.75;
        return lateFee;
    }

}