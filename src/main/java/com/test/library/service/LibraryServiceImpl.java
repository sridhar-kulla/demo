package com.test.library.service;

import com.test.library.model.Book;
import com.test.library.repo.LibraryRepo;
import com.test.library.repo.LibraryRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@Component
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepo libraryRepo;

    @Override
    public Collection<Book> getBooks() {
        Collection<Book> books = this.libraryRepo.getBooks();
        double lateFee = 0.0;
        int numDaysLate = 0;
        Book book = null;
        Iterator<Book> booksIter = books.iterator();
        while (booksIter.hasNext()) {
            book = booksIter.next();
            if (book.getAuthor().equals("Tom Smith")) {
                book.setAuthor(book.getAuthor() + "- CHECKED");
            }
        }
        return books;
    }
}
