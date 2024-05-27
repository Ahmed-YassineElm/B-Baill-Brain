package com.Feed.BBallBrainFeed.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
    }

    @Test
    void testGetAndSetId() {
        Long id = 1L;
        post.setId(id);
        assertEquals(id, post.getId());
    }

    @Test
    void testGetAndSetTitle() {
        String title = "Test Title";
        post.setTitle(title);
        assertEquals(title, post.getTitle());
    }

    @Test
    void testGetAndSetContent() {
        String content = "Test Content";
        post.setContent(content);
        assertEquals(content, post.getContent());
    }

    @Test
    void testGetAndSetCoachId() {
        Long coachId = 123L;
        post.setCoachId(coachId);
        assertEquals(coachId, post.getCoachId());
    }

    @Test
    void testGetAndSetCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        post.setCreatedAt(createdAt);
        assertEquals(createdAt, post.getCreatedAt());
    }

    @Test
    void testIsAndSetPublic() {
        boolean isPublic = true;
        post.setPublic(isPublic);
        assertTrue(post.isPublic());
    }
}
