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

    /**
     * 크롬 드라이브를 통해 게시글 정보를 모두 가져온다.
     * 가져온 글 중 "계명가족 특별할인 안내"라는 문구가 있다면 그것을 DB에 저장
     */
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

    /**
     * DB 안에 있는 게시글들을 조회한다.
     */
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
