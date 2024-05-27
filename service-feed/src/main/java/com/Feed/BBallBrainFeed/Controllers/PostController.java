package com.Feed.BBallBrainFeed.Controllers;

import com.Feed.BBallBrainFeed.Entities.Post;
import com.Feed.BBallBrainFeed.Feign.PostInterface;
import com.Feed.BBallBrainFeed.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    PostInterface postInterface;

    @GetMapping("/current")
    public ResponseEntity<List<Map<String, Object>>> getExternalCurrentUsers() {
        List<Map<String, Object>> users = postService.fetchCurrentUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPostsForUser() {

        List<Post> posts = postService.getPostsForUser();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        System.out.println(post.toString());
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
