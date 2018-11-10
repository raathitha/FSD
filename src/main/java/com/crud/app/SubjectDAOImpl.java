package com.crud.app;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Repository
public class SubjectDAOImpl implements SubjectDAO
{

    @Autowired
    private SessionFactory sessionFactory;
   
    @Bean  
    @Primary
    public void sessionFactory(HibernateEntityManagerFactory hemf){  
        this.sessionFactory= hemf.getSessionFactory();  
    } 

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/radha");
        dataSource.setUsername("root");
        dataSource.setPassword("Mk251kg7!");

        return dataSource;
    }
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
          LocalContainerEntityManagerFactoryBean em = new          LocalContainerEntityManagerFactoryBean();
          em.setDataSource(dataSource());
          em.setPackagesToScan(new String[] { "com.crud.app" });     
          JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
          em.setJpaVendorAdapter(vendorAdapter);
          return em;
       }
    // Saving a new Subject
    public void saveSubject(Subject subject)
    {
    	sessionFactory.getCurrentSession().save(subject);

    }

    // Getting a particular Subject
    public Subject getSubjectById(long id)
    {
    	return (Subject) sessionFactory.getCurrentSession().get(
    			Subject.class, id);
    }

    // Getting all the Subjects
    public List<Subject> getAllSubjects()
    {
    	return sessionFactory.getCurrentSession().createQuery("from Subject")
                .list();
    }

    // Updating a particular Subject
    public void updateSubject(Subject subject)
    {
    	 sessionFactory.getCurrentSession().update(subject);
       
    }

    // Deletion of a particular Subject
    public void deleteSubject(long id)
    {
    	Subject subject = (Subject) sessionFactory.getCurrentSession().load(
    			Subject.class, id);
        if (null != subject) {
            this.sessionFactory.getCurrentSession().delete(subject);
        }
    }
}