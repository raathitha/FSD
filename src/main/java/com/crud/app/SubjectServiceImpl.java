package com.crud.app;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService
{

	 @Autowired
	    private SubjectDAO subjectDAO;
    

	 @Override
    @Transactional
    public boolean saveSubject(Subject subject)
    {
    	subjectDAO.saveSubject(subject);
		 return true;
    }

	 @Override
	    @Transactional
    public Subject getSubjectById(long id)
    {
		 Subject bk = null;
		 if(subjectDAO.getSubjectById(id)!=null){
			 bk= subjectDAO.getSubjectById(id);
		 }
		 return bk;
    }

	 @Override
	    @Transactional
    public List<Subject> getAllSubjects()
    {
        
        List<Subject> subjectList = subjectDAO.getAllSubjects();
        return subjectList;
    }

	 @Override
	    @Transactional
    public boolean updateSubject(Subject subject)
    {
		 subjectDAO.updateSubject(subject);
		 return true;
    }

	 @Override
	    @Transactional
    public boolean deleteSubject(long id)
    {
		 subjectDAO.deleteSubject(id);
		 return true;
    }
	 public void setSubjectDAO(SubjectDAO subjectDAO) {
	        this.subjectDAO = subjectDAO;
	    }
}