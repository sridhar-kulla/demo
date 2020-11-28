package com.test.library.rest;

import com.test.library.model.Book;
import com.test.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class LibraryController{

    @Autowired
    private LibraryService libraryService;

    @GetMapping(value="/list-all-books",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Book> listAllBooks(){
        Collection<Book> books=libraryService.getBooks();
        return books;
    }

}