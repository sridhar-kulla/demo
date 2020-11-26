package com.test.library.model;

import com.test.library.exception.BadValueException;

public class BookNonFiction extends Book {
    private double lateFee;

    public BookNonFiction(long isbn, String title, String author) {
        super(isbn, title, author);
    }

    public double calculateLateFee(int numDaysLate) throws BadValueException {
        if(numDaysLate<0){
            throw new BadValueException();
        }
        lateFee=(numDaysLate*1.5)*0.80;
        return lateFee;
    }

}