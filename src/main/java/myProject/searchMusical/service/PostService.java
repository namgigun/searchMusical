package myProject.searchMusical.service;

import lombok.RequiredArgsConstructor;
import myProject.searchMusical.entity.Post;
import myProject.searchMusical.repository.PostRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final WebDriver webDriver;
    @Transactional
    public void load() {
        webDriver.get("https://www.kmu.ac.kr/page.jsp?mnu_uid=143");

        WebElement element = webDriver.findElement(By.className("board_st"));

        List<WebElement> elements = element.findElements(By.tagName("tr"));

        for (WebElement e : elements) {
            String content = e.findElement(By.className("subject")).getText();
            String writer = e.findElement(By.className("writer")).getText();
            String date = e.findElement(By.className("date")).getText();

            if(content.contains("계명가족 특별할인 안내")) {
                postRepository.save(new Post(content, writer, date));
            }
        }
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
