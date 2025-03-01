package myProject.searchMusical.repository;

import jakarta.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import myProject.searchMusical.domain.Board;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test
    public void test() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        driver.quit();
    }
}
