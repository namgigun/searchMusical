package myProject.searchMusical.repository;

import myProject.searchMusical.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
