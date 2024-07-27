package com.BlogApplication.REST.Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BlogApplication.REST.Blog.Entity.Post;
import com.BlogApplication.REST.Blog.Service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
    
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //localhost:8080/api/post/createPost
    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@RequestBody Post post)
    {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }
    
    //localhost:8080/api/post/getPost?id=1
    @GetMapping("/getPost")
    public ResponseEntity<Post> getPostDetails(@RequestParam long id)
    {
        return new ResponseEntity<>(postService.getPost(id),HttpStatus.OK);
    }

    //Delete Post Entity
    // localhost:8080/appi/post/deletePost?id=1
    @DeleteMapping("/deletePost")
    public String deletePostEntity(@RequestParam long id)
    {    
        return postService.deletePost(id);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost(@RequestParam long id, @RequestBody Post post)
    {
        return new ResponseEntity<>(postService.updatePost(id, post),HttpStatus.OK);
    }
}
    