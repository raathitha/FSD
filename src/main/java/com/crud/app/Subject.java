package com.crud.app;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SUBJECT", uniqueConstraints = {
        @UniqueConstraint(columnNames = "SUBJECTID")})
public class Subject implements Serializable 
{
    private static final long serialVersionUID = -1280037900360314186L;

    @Id
    @Column(name = "SUBJECTID", unique = true, nullable = false)
    private long subjectid;
    
    @Column(name = "TITLE",nullable = true, length = 500)    
	private String title;
    
    @Column(name = "DURATION", unique = false, nullable = false)    	
    private Integer duration;
    
    @Column(name = "BOOKS", unique = false) 
    private String books;
    public Subject()
    {
        super();
    }
    public Subject(long subjectid, String title, Integer duration, String books)
    {
        super();
        this.subjectid = subjectid;
        this.title = title;
        this.duration = duration;
        this.books = books;
    }
    public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}
	public long getSubjectid() {
		return subjectid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
    
    public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	@Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((subjectid == 0) ? 0 : String.valueOf(subjectid).hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((books == null) ? 0 : books.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Subject other = (Subject) obj;
        if (subjectid == 0)
        {
            if (other.subjectid != 0)
                return false;
        } else if (subjectid!=other.subjectid)
            return false;
        if (books == null)
        {
            if (other.books != null)
                return false;
        } else if (!books.equals(other.books))
            return false;
        if (duration == null)
        {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (title == null)
        {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "Subject [subjectid=" + subjectid + ", title=" + title + ", duration=" + duration + ", books=" + books + "]";
    }
}