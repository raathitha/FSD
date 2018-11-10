package com.crud.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "BOOK", uniqueConstraints = {
        @UniqueConstraint(columnNames = "BOOKID")})
public class Book implements Serializable 
{
    private static final long serialVersionUID = -1280037900360314186L;
    @Id
    @Column(name = "BOOKID", unique = true)
    private long bookid;
    
    @Column(name = "TITLE",  nullable = true, length = 500)    
 	 private String title;
 	 
    @Column(name = "PRICE", unique = false, nullable = false)
    private Double price;
 	 
    @Column(name = "VOLUME", unique = false, nullable = false)
    private Integer volume;
 	 
    @Column(name = "PUBLISHEDDATE", unique = false, nullable = true)
    private String publisheddate;
   public Book()
    {
        super();
    }
    public Book(long bookid, String title, Double price,Integer volume,String publisheddate)
    {
        super();
        this.bookid = bookid;
        this.title = title;
        this.price = price;
        this.volume = volume;
        this.publisheddate = publisheddate;
    }
 
	public long getBookid() {
		return bookid;
	}
	public void setBookid(long bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public String getpublisheddate() {
		return publisheddate;
	}
	public void setpublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}

    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookid == 0) ? 0 : String.valueOf(bookid).hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((volume == null) ? 0 : volume.hashCode());
        result = prime * result + ((publisheddate == null) ? 0 : publisheddate.hashCode());
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
        Book other = (Book) obj;
        if (bookid == 0)
        {
            if (other.bookid != 0)
                return false;
        } else if (bookid != other.bookid)
            return false;
        if (title == null)
        {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (price == null)
        {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (volume == null)
        {
            if (other.volume != null)
                return false;
        } else if (!volume.equals(other.volume))
            return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "Book [bookid=" + bookid + ", title=" + title + ", price=" + price + ", volume=" + volume + "]";
    }
}