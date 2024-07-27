package com.BlogApplication.REST.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlogApplication.REST.Blog.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>
{
    
}
