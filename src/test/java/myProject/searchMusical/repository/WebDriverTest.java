package myProject.searchMusical.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
@Log4j2
public class WebDriverTest {

    @Test
    public void firstScript() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://kream.co.kr/");

        log.info(driver.getTitle());
    }
}
