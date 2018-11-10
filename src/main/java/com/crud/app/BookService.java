package com.crud.app;

import java.util.List;

import org.springframework.context.annotation.Primary;


public interface BookService
{
    public boolean saveBook(Book book);
    public Book getBookById(long bookid);
    public boolean updateBook(Book book);
    public boolean deleteBook(long bookid);
    public List<Book> getAllBooks();
}