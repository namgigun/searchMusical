package myProject.searchMusical.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class TestController {
    public final ChromeDriver chromeDriver;

    @GetMapping("/")
    public void test() {
        chromeDriver.get("https://books.toscrape.com/");
        log.info(chromeDriver.getTitle());
    }
}
