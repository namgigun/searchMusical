package myProject.searchMusical.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
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
