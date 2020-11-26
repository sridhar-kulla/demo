package com.test.library.repo;

import com.test.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LibraryRepo {
     Collection<Book> getBooks();
}
