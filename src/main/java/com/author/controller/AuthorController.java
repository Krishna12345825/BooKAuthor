package com.author.controller;

import com.author.entities.Author;
import com.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AuthorController {



/*
    @GetMapping("/authors")
    @ResponseBody
    public Author getAuthors()
    {
        Author author = new Author();
        author.setAuthorId(1);
        author.setAuthorFname("Krishna");
        author.setAuthorLname("Kumar");
        author.setAuthorEmail("krishnabhai@gmail.com");
        author.setAuthorLanguage("English");
        author.setAuthorBio("Hey Im krishna Kumar from Btech CSE at Centurion University Of Technology ");
        return author;
    }*/


    @Autowired
    private AuthorService authorService;



    // Get author handler
    @GetMapping("/Author/list")
    public List<Author> getAuthors(){
        return  this.authorService.getAllAuthors();
    }


    // Get author handler by Id
    @GetMapping("/Author/{id}")
    public Author getAuthor(@PathVariable("id") int id) {
        return authorService.getAuthorById(id);
    }



    // post author handler
    @PostMapping("/Author/post")
    public Author addAuthor(@RequestBody Author author) {
        Author b = this.authorService.addOrUpdateAuthor(author);
        System.out.println(author);
        return b;
    }



    // delete author handler
    @DeleteMapping("/Author/delete/{authorId}")
    public void deleteAuthor(@PathVariable("authorId") int authorId) {
        this.authorService.deleteAuthor(authorId);
    }


    // update author handler
    @PutMapping("/Author/update/{authorId}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("authorId") int authorId)
    {
        author.setAuthorId(authorId);
        this.authorService.addOrUpdateAuthor(author);
        return author;
    }
}