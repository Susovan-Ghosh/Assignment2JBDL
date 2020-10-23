package com.JBDL.Assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getBooksByAuthor")
    public List<Book> getBooksByAuthor(@RequestParam("author_name") String author_name) {
        return bookRepository.getBooksByAuthor(author_name);
    }

    @PostMapping("/createBooks")
    public void createBooks(@RequestBody List<Book> books) {
        long start = System.currentTimeMillis();
        bookRepository.saveAll(books);
        long end = System.currentTimeMillis();
        System.out.println("Without multi-threading time :" + (end - start));
    }

    @PostMapping("/createBooksMultiThreading")
    public void createBooksMultiThreading(@RequestBody List<Book> books) {
        int n = books.size();
        BookController bookController = new BookController();
        MyThread bookThread[] = new MyThread[n];
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            bookThread[i] = new MyThread(bookRepository, books.get(i));
            bookThread[i].start();
        }
        long end = System.currentTimeMillis();
        System.out.println("With multi-threading time :" + (end - start));
    }
}
