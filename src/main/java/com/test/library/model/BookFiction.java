package com.test.library.model;

public class BookFiction extends Book{
    private double lateFee;

    public BookFiction(long isbn, String title, String author) {
        super(isbn, title, author);
    }

    public double calculateLateFee(int numDaysLate) throws Exception {
        if(numDaysLate<0){
            throw new Exception("Bad Value");
        }
        lateFee=(numDaysLate/2)*0.75;
        return lateFee;
    }

}