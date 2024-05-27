package com.Feed.BBallBrainFeed.Repositories;




import com.Feed.BBallBrainFeed.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByIsPublicTrue();
    List<Post> findByIsPublicTrueAndCoachId(Long  coachId);
}
