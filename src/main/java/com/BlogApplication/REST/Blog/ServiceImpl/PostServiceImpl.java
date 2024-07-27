package com.BlogApplication.REST.Blog.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogApplication.REST.Blog.Entity.Post;
import com.BlogApplication.REST.Blog.Repository.PostRepository;
import com.BlogApplication.REST.Blog.Service.PostService;;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }



    @Override
    public Post createPost(Post post) {
        Post newPost = new Post();
        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        newPost.setContent(post.getContent());

        Post updatedPost = postRepository.save(newPost);

        return updatedPost;

    }
    
    @Override
    public Post getPost(long postId) {
        Post post = postRepository.getReferenceById(postId);
        Post retPost = new Post();
        retPost.setId(post.getId());
        retPost.setContent(post.getContent());
        retPost.setDescription(post.getDescription());
        retPost.setTitle(post.getTitle());
        return retPost;
    }

    @Override
    public String deletePost(long postId) {

        postRepository.deleteById(postId);
        return postId + "Post Id Entity deleted succesffully";
    }

    @Override
    public Post updatePost(long id, Post post) {
        Post post1 = postRepository.getReferenceById(id);
        post1.setDescription(post.getDescription());
        post1.setTitle(post.getTitle());
        post1.setId(id);

        Post updatedPost = postRepository.save(post1);
        return updatedPost;
    }
}

