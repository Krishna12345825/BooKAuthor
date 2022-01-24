package com.author.service;

import com.author.entities.Author;
import com.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {



/*    private  static List<Author> list = new ArrayList<>();
    static {
        list.add(new Author(1,"Krishna", "Kumar","krishnabhai@gmail.com","English","Hey Im krishna Kumar from Btech CSE at cutm "));
        list.add(new Author(2,"Omar", "Kumar","omkarbhai@gmail.com","Hindi","Hey Im Narendra  Kumar from BTech CSE at cutm "));
    }*/




    @Autowired
    private AuthorRepository authorRepository;



    // get all authors
    public List<Author> getAllAuthors() {
        List<Author> list=(List<Author>)this.authorRepository.findAll();
        return list;
    }




    // get single author by id
    public Author getAuthorById(int id) {
        Author author = null;
        //  book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
        author=this.authorRepository.findById(id);
        return author;
    }





    // Adding the author
    public Author addOrUpdateAuthor(Author b) {
        // list.add(b);
        // return b;

        Author result=authorRepository.save(b);
        return result;
    }



    // delete author
    public void deleteAuthor(int bid) {

//    	 list.stream().filter(book ->{
//    		 if(book.getBookId()!=bid) {
//    			 return true;
//    		 }
//    		 else {
//    			 return false;
//    		 }
//    	 }).collect(Collectors.toList());
//

        //  list = list.stream().filter(book -> book.getBookId() != bid).collect(Collectors.toList());

        authorRepository.deleteById(bid);
    }





//    // update the author
//    public void updateAuthor(Author author, int authorId) {
//
////          list = list.stream().map(b -> {
////              if (b.getBookId() == bookId) {
////                  b.setBookTitle(book.getBookTitle());
////                  b.setAuthor(book.getAuthor());
////              }
////              return b;
////          }).collect(Collectors.toList());
//
//        author.setAuthorId(authorId);
//        authorRepository.save(author);
//
//    }





}
