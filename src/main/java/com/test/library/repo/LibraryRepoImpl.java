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
        Book book = null;
        //ArrayList<Book> arrayList = new ArrayList<>();
        String fileName="C:/Users/sridh/IdeaProjects/Library-Project/src/main/resources/Books.txt";
        Scanner input=null;
        String str=null;
        try {
             input = new Scanner(new File(fileName));

             while(input.hasNextLine()){
                  str=input.nextLine();
             }

            Scanner scr=new Scanner(str);
            scr.useDelimiter("[|]");
            String type,title,author;
            long isbn;

            while (scr.hasNext()) {
                 type=scr.next();
                System.out.println(type);
                 isbn= Long.parseLong(scr.next());
                System.out.println(isbn);
                 title=scr.next();
                System.out.println(title);
                 author=scr.next();
                System.out.println(author);


                // Current line of book data's fields in: bookType, bookIsbn, bookTitle, bookAuthor

                if (type.equals("FICTION")) {
                    book = new BookFiction(isbn, title, author);
                } else if (type.equals("NONFICTION")) {
                    book = new BookNonFiction(isbn,title,author);
                }
                if (book != null) {
                    System.out.println("Book");
                }
            }
            scr.close();
        }
        catch (IOException e) {
            // Handle a potential exception
            e.printStackTrace();
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
       System.out.println(book.getType() + " " + book.getTitle()+" "+book.getIsbn());
       return Collections.singleton(book);
    }

}
