package com.author.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(length = 25)
    private  String authorFname;

    @Column(length = 25)
    private  String authorLname;

    @Column(length = 35)
    private  String authorEmail;

    @Column(length = 25)
    private  String authorLanguage;

    @Column(length = 250)
    private  String authorBio;




    //    @OneToMany(cascade = CascadeType.ALL)   Unidirectional Mapping
//    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
//    private List<BlogPost> blogPosts;




   // mappedBy = "author"
    @OneToMany(cascade = CascadeType.ALL)  //Bidirectional Mapping  OneToMany
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private List<BlogPost> blogPosts;



    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    public Author() {

    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFname() {
        return authorFname;
    }

    public void setAuthorFname(String authorFname) {
        this.authorFname = authorFname;
    }

    public String getAuthorLname() {
        return authorLname;
    }

    public void setAuthorLname(String authorLname) {
        this.authorLname = authorLname;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorLanguage() {
        return authorLanguage;
    }

    public void setAuthorLanguage(String authorLanguage) {
        this.authorLanguage = authorLanguage;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }



    public Author(int authorId, String authorFname, String authorLname, String authorEmail, String authorLanguage, String authorBio) {
        this.authorId = authorId;
        this.authorFname = authorFname;
        this.authorLname = authorLname;
        this.authorEmail = authorEmail;
        this.authorLanguage = authorLanguage;
        this.authorBio = authorBio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorFname='" + authorFname + '\'' +
                ", authorLname='" + authorLname + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorLanguage='" + authorLanguage + '\'' +
                ", authorBio='" + authorBio + '\'' +
                '}';
    }



}
