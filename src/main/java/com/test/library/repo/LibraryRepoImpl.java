package com.test.library.repo;

import com.test.library.model.Book;
import com.test.library.model.BookFiction;
import com.test.library.model.BookNonFiction;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class LibraryRepoImpl implements LibraryRepo {

    @Override
    public Collection<Book> getBooks() {
        Book book=null;
        Book localBook=null;
        ArrayList<Book> listOfRecords=new ArrayList<>(5);
        String fileName="C:/Users/sridh/IdeaProjects/Library-Project/src/main/resources/Books.txt";
        Scanner input=null;
        String str=null;
        try {
             input = new Scanner(new File(fileName));
             while(input.hasNextLine()){
                  str=input.nextLine();
                 Scanner scr=new Scanner(str);
                 scr.useDelimiter("[|]");
                 String type,title,author;
                 long isbn;
                 while (scr.hasNext()) {
                     type=scr.next();
                     isbn= Long.parseLong(scr.next());
                     title=scr.next();
                     author=scr.next();

                     // Current line of book data's fields in: bookType, bookIsbn, bookTitle, bookAuthor

                     if (type.equals("FICTION")) {
                         localBook = new BookFiction(isbn, title, author);
                     } else if (type.equals("NONFICTION")) {
                         localBook = new BookNonFiction(isbn,title,author);
                     }
                     if (localBook != null) {
                         listOfRecords.add(localBook);
                         System.out.println(localBook.getIsbn() + " " + localBook.getTitle()+" "+localBook.getAuthor());
                     }
                 }

                 scr.close();

                    // System.out.println(localBook.getIsbn() + " " + localBook.getTitle()+" "+localBook.getAuthor());
             }

        }
        catch (IOException e) {
            // Handle a potential exception
            e.printStackTrace();
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
       //System.out.println(book.getIsbn() + " " + book.getTitle()+" "+book.getIsbn());

            return listOfRecords;

    }

}
