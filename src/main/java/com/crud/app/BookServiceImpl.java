package com.crud.app;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BookServiceImpl implements BookService
{

	 @Autowired
	    private BookDAO bookDAO;
    

	 @Override
	 @Transactional
    public boolean saveBook(Book book)
    {
    	bookDAO.saveBook(book);
    	return true;
    }

	 @Override
	    @Transactional
    public Book getBookById(long id)
    {
		 Book bk = null;
		 if(bookDAO.getBookById(id)!=null){
			 bk= bookDAO.getBookById(id);
		 }
		 return bk;
    }

	 @Override
	    @Transactional
    public List<Book> getAllBooks()
    {
        
        List<Book> bookList = bookDAO.getAllBooks();
        return bookList;
    }

	 @Override
	    @Transactional
    public boolean updateBook(Book book)
    {
		 bookDAO.updateBook(book);
	    	return true;
    }

	 @Override
	    @Transactional
    public boolean deleteBook(long id)
    {
		 bookDAO.deleteBook(id);
	    	return true;
    }
	 public void setBookDAO(BookDAO bookDAO) {
	        this.bookDAO = bookDAO;
	    }
}