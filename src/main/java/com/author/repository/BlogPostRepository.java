package com.author.repository;

import com.author.entities.Author;
import com.author.entities.BlogPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogPostRepository extends CrudRepository<BlogPost, Integer> {
    public BlogPost findById(int id);
    public  List<BlogPost> getBlogPostsByAuthor_AuthorId(int authorId);

}
