package com.author.service;

import com.author.entities.Author;
import com.author.entities.BlogContents;
import com.author.entities.BlogPost;
import com.author.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;


    // get all blogPost
    public List<BlogPost> getAllBlogPost() {
        List<BlogPost> list=(List<BlogPost>)this.blogPostRepository.findAll();
        return list;
    }


    // get single blogPost by id
    public BlogPost getBlogPostById(int id) {
        BlogPost blogPost = null;
        //  book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
        blogPost=this.blogPostRepository.findById(id);
        return blogPost;
    }





    // Adding the blogPost
    public BlogPost addOrUpdateBlogPost(BlogPost bg) {
        // list.add(b);
        // return b;
        BlogPost result=blogPostRepository.save(bg);
        return result;
    }

    public boolean update( String blogTitle,String blogDate, BlogContents blogContent, int blogId, int authorId)
    {
        BlogPost blogPost=getBlogPostById(blogId);
        blogPost.setBlogTitle(blogTitle);
        blogPost.setBlogDate(blogDate);
        blogPost.setBlogContent(blogContent);
        Author author=new Author();
        author.setAuthorId(authorId);
        blogPost.setAuthor(author);
        blogPostRepository.save(blogPost);
        return true;
    }


    // delete blogPost
    public void deleteBlogPost(int bid) {

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

        blogPostRepository.deleteById(bid);
    }



//    // update the blogPost
//    public void updateBlogPost(BlogPost blogPost, int blogId) {
//
////          list = list.stream().map(b -> {
////              if (b.getBookId() == bookId) {
////                  b.setBookTitle(book.getBookTitle());
////                  b.setAuthor(book.getAuthor());
////              }
////              return b;
////          }).collect(Collectors.toList());
//
//        blogPost.setBlogId(blogId);
//        blogPostRepository.save(blogPost);
//
//    }


    public List<BlogPost> getBlogPostsByAuthor_AuthorId(int id)
    {
        return blogPostRepository.getBlogPostsByAuthor_AuthorId(id);
    }


}
