package com.JBDL.Assignment2;

public class MyThread extends Thread {
    private Book book;
    private BookRepository bookRepository;

    public MyThread(BookRepository bookRepository, Book book) {
        this.book = book;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run() {
        this.bookRepository.save(this.book);
    }
}