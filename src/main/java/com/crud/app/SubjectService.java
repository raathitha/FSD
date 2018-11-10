package com.crud.app;

import java.util.List;

public interface SubjectService
{
    public boolean saveSubject(Subject subject);
    public Subject getSubjectById(long subjectid);
    public boolean updateSubject(Subject subject);
    public boolean deleteSubject(long subjectid);
    public List<Subject> getAllSubjects();
}