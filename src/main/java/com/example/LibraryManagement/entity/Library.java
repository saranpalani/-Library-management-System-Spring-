
package com.example.LibraryManagement.entity;

public class Library {

    private int id;
    private String book;
    private String author;
    private int pages;


    public Library() {
    }


    public Library(int id, String book, String author, int pages) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.pages = pages;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

