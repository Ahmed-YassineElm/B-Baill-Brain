package com.Feed.BBallBrainFeed.Services;

import com.Feed.BBallBrainFeed.Entities.Post;
import com.Feed.BBallBrainFeed.Feign.PostInterface;
import com.Feed.BBallBrainFeed.Repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private PostInterface postInterface;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchCurrentUsers_ShouldReturnListOfUsers() {
        // Arrange
        List<Map<String, Object>> users = new ArrayList<>();
        when(postInterface.getCurrentUsers()).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));

        // Act
        List<Map<String, Object>> result = postService.fetchCurrentUsers();

        // Assert
        assertEquals(users, result);
        verify(postInterface, times(1)).getCurrentUsers();
    }

    @Test
    void getPostsForUser_ShouldReturnPostsForCoach() {
        // Arrange
        List<Map<String, Object>> users = new ArrayList<>();
        Map<String, Object> user = new HashMap<>();
        user.put("userID", "1");
        user.put("role", "COACH");
        users.add(user);

        when(postInterface.getCurrentUsers()).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));
        List<Post> posts = new ArrayList<>();
        when(postRepository.findByIsPublicTrueAndCoachId(1L)).thenReturn(posts);

        // Act
        List<Post> result = postService.getPostsForUser();

        // Assert
        assertEquals(posts, result);
        verify(postInterface, times(1)).getCurrentUsers();
        verify(postRepository, times(1)).findByIsPublicTrueAndCoachId(1L);
    }

    @Test
    void getPostsForUser_ShouldReturnPublicPostsForOtherRoles() {
        // Arrange
        List<Map<String, Object>> users = new ArrayList<>();
        Map<String, Object> user = new HashMap<>();
        user.put("userID", "1");
        user.put("role", "PLAYER");
        users.add(user);

        when(postInterface.getCurrentUsers()).thenReturn(new ResponseEntity<>(users, HttpStatus.OK));
        List<Post> posts = new ArrayList<>();
        when(postRepository.findByIsPublicTrue()).thenReturn(posts);

        // Act
        List<Post> result = postService.getPostsForUser();

        // Assert
        assertEquals(posts, result);
        verify(postInterface, times(1)).getCurrentUsers();
        verify(postRepository, times(1)).findByIsPublicTrue();
    }

    @Test
    void createPost_ShouldReturnCreatedPost() {
        // Arrange
        Post post = new Post();
        post.setCoachId(123L);
        post.setCreatedAt(LocalDateTime.now());
        post.setPublic(true);

        when(postRepository.save(post)).thenReturn(post);

        // Act
        Post result = postService.createPost(post);

        // Assert
        assertNotNull(result);
        assertEquals(123L, result.getCoachId());
        assertEquals(true, result.isPublic());
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void deletePost_ShouldInvokeDeleteById() {
        // Arrange
        Long postId = 1L;
        doNothing().when(postRepository).deleteById(postId);

        // Act
        postService.deletePost(postId);

        // Assert
        verify(postRepository, times(1)).deleteById(postId);
    }
}
