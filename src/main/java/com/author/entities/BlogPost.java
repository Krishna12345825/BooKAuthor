package com.author.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int blogId;

    @Column(length = 25)
    private  String blogTitle;

  //  @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String blogDate;




    @Enumerated(EnumType.STRING)
    private BlogContents blogContent;


    @ManyToOne
    @JoinColumn(name = "author_id")   // Bydirectional Mapping ManyToOne
    private Author author;


    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public BlogContents getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(BlogContents blogContent) {
        this.blogContent = blogContent;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public BlogPost(int blogId, String blogTitle, String blogDate, BlogContents blogContent, Author author) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogDate = blogDate;
        this.blogContent = blogContent;
        this.author = author;
    }

    public BlogPost() {
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogDate='" + blogDate + '\'' +
                ", blogContent=" + blogContent +
                ", author=" + author +
                '}';
    }
}

