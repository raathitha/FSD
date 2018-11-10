package com.crud.app;

import java.util.List;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = "classpath:SpringMVC-servlet-Test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {
	 @Autowired
	  private BookService bkService;
	 Book bk = new Book();
	 @Autowired
	  private SubjectService suService;
	 Subject sub = new Subject();
	@Test
    @Transactional
    @Rollback(true)
	public void testListBook(){
		
		 List<Book> bks = bkService.getAllBooks();
		 if(bks !=null){
			 Assert.assertEquals(bks.size(), 2);
		 }
	} 
	 
	 @Test
	    @Transactional
	    @Rollback(true)
		public void testFindBook(){
			
		 Book bkFound = bkService.getBookById(1);
		 if(bkFound !=null){
			 Assert.assertEquals(bkFound.getTitle(), "Lorem ipsum");
		 }
		}  
	 
	@Test
    @Transactional
    @Rollback(true)
	public void testAddBook(){
		 bk.setBookid(232424);
		 bk.setPrice(29.00);
		 bk.setTitle("SetTitle");
		 bk.setVolume(121);
		 bk.setpublisheddate("2018-01-01");  
		 bkService.saveBook(bk);
		 Book bkFound = bkService.getBookById(232424);
		 if(bkFound !=null){
			 Assert.assertEquals(bkFound.getTitle(), bk.getTitle());
		 }
	}
	@Test
    @Transactional
    @Rollback(true)
	public void testDeleteBook(){
		 bk.setBookid(232424);
		 bk.setPrice(29.00);
		 bk.setTitle("SetTitle");
		 bk.setVolume(121);
		 bk.setpublisheddate("2018-01-01");  
		 bkService.saveBook(bk);
		 Book bkFound = bkService.getBookById(232424);
		 if(bkFound !=null){
			 bkService.deleteBook(232424);
			 Book bkFound2 = bkService.getBookById(232424);
			  assertNull(bkFound2);
		 }
	}
	@Test
    @Transactional
    @Rollback(true)
	public void testListSubject(){
		
		 List<Subject> subs = suService.getAllSubjects();
		 if(subs !=null){
			 Assert.assertEquals(subs.size(), 9);
		 }
	} 
	 
	 @Test
	    @Transactional
	    @Rollback(true)
		public void testFindSubject(){
			
		 Subject suFound = suService.getSubjectById(10);
		 if(suFound !=null){
			 Assert.assertEquals(suFound.getTitle(), "Subject11");
		 }
		}  
	 
	@Test
    @Transactional
    @Rollback(true)
	public void testAddSubject(){
		 sub.setSubjectid(15);
		 sub.setBooks("1,2");
		 sub.setTitle("subTitle");
		 sub.setDuration(3);
		 suService.saveSubject(sub);
		 Subject suFound = suService.getSubjectById(15);
		 if(suFound !=null){
			 Assert.assertEquals(suFound.getTitle(), sub.getTitle());
		 }
	}
	@Test
    @Transactional
    @Rollback(true)
	public void testDeleteSubject(){
		sub.setSubjectid(15);
		 sub.setBooks("1,2");
		 sub.setTitle("subTitle");
		 sub.setDuration(3);
		 suService.saveSubject(sub);
		 Subject suFound = suService.getSubjectById(15);
		 if(suFound !=null){
			 suService.deleteSubject(15);
			 Subject suFound2 = suService.getSubjectById(15);
			  assertNull(suFound2);
		 }
	}
}
