package com.crud.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RestController
public class BookController
{
	@Autowired
    private BookService bookService;
 
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/subjects").setViewName("subjects");
        registry.addViewController("/books").setViewName("books");
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/JSP/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @RequestMapping(value = "/book",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveBook(@ModelAttribute("book") Book book)
    {
        try
        {
        	System.out.println("inside book________________________________________"+book);
        	System.out.println("inside book________________________________________"+book.getBookid());
        	System.out.println("inside book________________________________________"+bookService.getAllBooks());
        	
        	if(bookService.getBookById(book.getBookid()) != null)
        		{
            	System.out.println("inside book______________________2__________________"+book);
            	bookService.updateBook(book);}else{
            		

                	System.out.println("inside book______________________3__________________"+book);
        			bookService.saveBook(book);
        		}
        	
            	
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch____________________________________");
            bookService.saveBook(book);
        }
        return new ModelAndView("redirect:/books");
    }
   
     @RequestMapping(value = "/editBook/{id}")
     @ResponseBody     
    public ModelAndView editBook(@ModelAttribute("book") Book book,@PathVariable("id") int id)
    {
        ModelAndView model = new ModelAndView("books");
        
        book = bookService.getBookById(id);
        List bookList = bookService.getAllBooks();
        
        model.addObject("book",book);        
        model.addObject("bookList",bookList);
        
        return model;
    }
    
    @RequestMapping(value = "/deleteBook/{id}")
    @ResponseBody
    public ModelAndView deleteBook(@ModelAttribute("book") Book book,@PathVariable("id") int id)
    {
    	bookService.deleteBook(id);
        
        return new ModelAndView("redirect:/books");
    }

    @RequestMapping(value = "/books")
    @ResponseBody
     public ModelAndView listBooks(@ModelAttribute("book") Book book)
    {
        ModelAndView model = new ModelAndView("books");

        List bookList = bookService.getAllBooks();
        System.out.println(bookList);
        model.addObject("bookList", bookList);
        
        return model;
    }
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/subject",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveSubject(@ModelAttribute("subject") Subject subject)
    {
        try
        {
            if(subjectService.getSubjectById(subject.getSubjectid()) != null){

            	 System.out.println("inside tryif"+subject);
                  subjectService.updateSubject(subject);
            }else{

           	 System.out.println("inside tryelse"+subject);
                subjectService.saveSubject(subject);
            }
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch");
            subjectService.saveSubject(subject);
        }
        return new ModelAndView("redirect:/subjects");
    }

    @RequestMapping(value = "/searchBook",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchBook(@ModelAttribute("book") Book book)
    {
    	 ModelAndView model = new ModelAndView("books"); List bookList = bookService.getAllBooks();
	        System.out.println(bookList);
	        model.addObject("bookList", bookList); 
    	try
        {
        	if(bookService.getBookById(book.getBookid()) != null)
        	{
        		 Book bookFound = bookService.getBookById(book.getBookid());

     	        model.addObject("showTable","true");     
        	        model.addObject("bookFound",bookFound);      
        	}
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch");
            
        }
        return model;
    }
    @RequestMapping(value = "/searchSubject",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchSubject(@ModelAttribute("subject") Subject subject)
    {
    	 ModelAndView model = new ModelAndView("subjects"); 
    	 List subjectList = subjectService.getAllSubjects();
	        model.addObject("subjectList", subjectList); 
    	try
        {
        	if(subjectService.getSubjectById(subject.getSubjectid()) != null)
        	{
        		Subject subjectFound = subjectService.getSubjectById(subject.getSubjectid());
        		
        	        model.addObject("subjectFound",subjectFound); 
        	        model.addObject("showTable","true");     
        	}
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch");
            
        }
        return model;
    }
    @RequestMapping(value = "/editSubject/{id}")
    @ResponseBody
    public ModelAndView editSubject(@ModelAttribute("subject") Subject subject,@PathVariable("id") int id)
    {
        ModelAndView model = new ModelAndView("subjects");
        
        subject = subjectService.getSubjectById(id);
        List subjectList = subjectService.getAllSubjects();
        
        model.addObject("subject",subject);        
        model.addObject("subjectList",subjectList);
        
        return model;
    }
  
    @RequestMapping(value = "/deleteSubject/{id}")
    @ResponseBody
    public ModelAndView deleteSubject(@ModelAttribute("subject") Subject subject,@PathVariable("id") int id)
    {
        subjectService.deleteSubject(id);
        
        return new ModelAndView("redirect:/subjects");
    }

    @RequestMapping(value = "/subjects")
    @ResponseBody
    public ModelAndView listSubjects(@ModelAttribute("subject") Subject subject)
    {
        ModelAndView model = new ModelAndView("subjects");

        List subjectList = subjectService.getAllSubjects();
        System.out.println(subjectList);
        model.addObject("subjectList", subjectList);
        
        return model;
    }
}