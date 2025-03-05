package myProject.searchMusical.repository;

import lombok.extern.log4j.Log4j2;
import myProject.searchMusical.entity.Post;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@SpringBootTest
@Log4j2
@Transactional
public class WebDriverTest {

    @Autowired
    WebDriver driver;

    @Autowired
    PostRepository postRepository;

    @Test
    public void test() {
        driver.get("https://kream.co.kr/");

        log.info(driver.getTitle());

        driver.quit();
    }
}
