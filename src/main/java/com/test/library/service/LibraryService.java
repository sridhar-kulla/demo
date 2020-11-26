package com.test.library.service;

import com.test.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface LibraryService {
  Collection<Book> getBooks();
}
