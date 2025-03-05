package myProject.searchMusical.repository;

import lombok.extern.log4j.Log4j2;
import myProject.searchMusical.entity.Post;
import myProject.searchMusical.service.PostService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    WebDriver webDriver;

    @Autowired
    PostService postService;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Post post = Post.builder()
                    .content("content.." + i)
                    .writer("user" + (i % 10))
                    .build();

            Post result = postRepository.save(post);
            log.info("BNO: " + result.getId());
        });
    }

    @Test
    public void testDelete() {
        Long bno = 1L;
        postRepository.deleteById(bno);
    }
}