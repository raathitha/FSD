package com.crud.app;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
@Repository
public class BookDAOImpl implements BookDAO
{

    @Autowired
    private SessionFactory sessionFactory;
   
    @Bean  
    public void sessionFactory(HibernateEntityManagerFactory hemf){  
        this.sessionFactory= hemf.getSessionFactory();  
    } 
@Override
    // Saving a new Book
    public void saveBook(Book book)
    {
    	sessionFactory.getCurrentSession().save(book);
    }

@Override  // Getting a particular Book
    public Book getBookById(long id)
    {
    	return (Book) sessionFactory.getCurrentSession().get(
    			Book.class, id);
    }

    // Getting all the Books

public List<Book> getAllBooks()
    {
    	return sessionFactory.getCurrentSession().createQuery("from Book")
                .list();
    }

    // Updating a particular Book
@Override
public void updateBook(Book book)
    {
    	 sessionFactory.getCurrentSession().update(book);
       
    }

    // Deletion of a particular Book
@Override
public void deleteBook(long id)
    {
    	Book book = (Book) sessionFactory.getCurrentSession().load(
    			Book.class, id);
        if (null != book) {
            this.sessionFactory.getCurrentSession().delete(book);
        }
    }
}