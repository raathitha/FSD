package com.crud.app;

import java.util.List;

public interface BookDAO
{
    public void saveBook(Book book);
    public Book getBookById(long bookid);
    public void updateBook(Book book);
    public void deleteBook(long bookid);
    public List<Book> getAllBooks();
}