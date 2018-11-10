package com.crud.app;

import java.util.List;

public interface SubjectDAO
{
    public void saveSubject(Subject subject);
    public Subject getSubjectById(long id);
    public void updateSubject(Subject subject);
    public void deleteSubject(long id);
    public List<Subject> getAllSubjects();
}