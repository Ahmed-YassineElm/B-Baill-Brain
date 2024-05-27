package com.Feed.BBallBrainFeed.Services;



import com.Feed.BBallBrainFeed.Entities.Post;
//import com.Feed.BBallBrainFeed.Feign.PostInterface;
import com.Feed.BBallBrainFeed.Feign.PostInterface;
import com.Feed.BBallBrainFeed.Repositories.PostRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostInterface postInterface;

    public List<Map<String, Object>> fetchCurrentUsers() {
        ResponseEntity<List<Map<String, Object>>> response = postInterface.getCurrentUsers();
        return response.getBody();
    }



//    public List<Post> getPostsForUser() {
//        List<Map<String, Object>> currentUsers = fetchCurrentUsers();
//
//        // Simulate fetching the current user's ID and role (this should be dynamic in a real app)
//        String userID = "1234"; // Replace with actual logic to get the current user's ID
//        String role = "ROLE_USER"; // Replace with actual logic to get the current user's role
//
//        // Logic based on user role
//
//            return postRepository.findByIsPublicTrue();  // Default to public posts for other roles or unauthenticated users
//
//    }

    public List<Post> getPostsForUser() {
        List<Map<String, Object>> userList  = postInterface.getCurrentUsers().getBody();

        Map<String, Object> user = userList.get(0);
        String userID = String.valueOf(user.get("userID"));
        String role = String.valueOf(user.get("role"));

        if ("COACH".equals(role)) {
            return getPostsForCoach(Long.parseLong(userID));
//        } else if ("PLAYER".equals(role)) {
//            coachId = postInterface.getCoachId(userID);
//            return getPostsForCoach(coachId);
        } else {
            return postRepository.findByIsPublicTrue();  // Default to public posts for other roles or unauthenticated users
        }
    }


    private List<Post> getPostsForCoach(Long  coachId) {
        return postRepository.findByIsPublicTrueAndCoachId(coachId);
    }


    public Post createPost(Post post) {
        post.setCoachId(123L);
        post.setCreatedAt(LocalDateTime.now());
        post.setPublic(true);
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
