package com.author.controller;

import com.author.entities.Author;
import com.author.entities.BlogContents;
import com.author.entities.BlogPost;
import com.author.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BlogPostController {



    @Autowired
    private BlogPostService blogPostService;



    // Get blogpost handler
    @GetMapping("/BlogPost/list")
    public List<BlogPost> getBlogPost(){
        return  this.blogPostService.getAllBlogPost();
    }



    // Get blogpost  handler by Id
    @GetMapping("/BlogPostById/{blogId}")
    public BlogPost getBlogPost(@PathVariable("blogId") int blogId){
        return blogPostService.getBlogPostById(blogId);
    }


//  // Post blogPost handler
//    @PostMapping("/BlogPostByAdd")
//    public BlogPost addBlogPost(@RequestBody BlogPost blogPost) {
//        BlogPost bg = this.blogPostService.addOrUpdateBlogPost(blogPost);
//        System.out.println(blogPost);
//        return bg;
//    }

    // Post Blog Handler
    @PostMapping("/BlogPostByAdd")
    public  BlogPost addBlogPost(@RequestParam(value = "blogTitle") String blogTitle,
                                 @RequestParam(value = "blogDate") String  blogDate,
                                 @RequestParam(value = "blogContent") BlogContents blogContent,
                                 @RequestParam(value="authorId") int authorId){


        BlogPost blogPost = new BlogPost();
        Author author = new Author();
        blogPost.setBlogTitle(blogTitle);
        blogPost.setBlogDate(blogDate);
        blogPost.setBlogContent(blogContent);
        author.setAuthorId(authorId);
        blogPost.setAuthor(author);
        return blogPostService.addOrUpdateBlogPost(blogPost);

    }


    // delete blogPost handler
    @DeleteMapping("/BlogPost/delete/{blogId}")
    public void deleteBlogPost(@PathVariable("blogId") int blogId)
    {
        this.blogPostService.deleteBlogPost(blogId);
    }



//    @RequestMapping(value="update")
//    public @ResponseBody String save(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
//        if (demoEntityService.updateEntity(id, name))
//            return "SUCCESS";
//        else
//            return "NOT FOUND";
//    }


    @PostMapping("/BlogPost/Update")
    public  boolean updateBlogPost(@RequestParam(value = "blogTitle") String blogTitle,
                                 @RequestParam(value = "blogDate") String  blogDate,
                                 @RequestParam(value = "blogContent") BlogContents blogContent,
                                   @RequestParam(value="blogId") int blogId,
                                 @RequestParam(value="authorId") int authorId)
    {


//        BlogPost blogPost = new BlogPost();
//        Author author = new Author();
//        blogPost.setBlogTitle(blogTitle);
//        blogPost.setBlogDate(blogDate);
//        blogPost.setBlogContent(blogContent);
//        author.setAuthorId(authorId);
//        blogPost.setAuthor(author);
        blogPostService.update(blogTitle,blogDate,blogContent,blogId,authorId);
        return true;

    }



    // update blogPost handler
//    @PutMapping("/BlogPost/update/{blogId}")
//    public BlogPost updateBlogPost(@RequestBody BlogPost blogPost, @PathVariable
//            ("blogId") int blogId)
//    {
//        this.blogPostService.addOrUpdateBlogPost(blogPost);
//        return blogPost;
//    }



    @GetMapping("/AuthorListBy/{author_id}")
    public  List<BlogPost> blogPostByAuthorId(@PathVariable int author_id)
    {
        return  blogPostService.getBlogPostsByAuthor_AuthorId(author_id);
    }
}
