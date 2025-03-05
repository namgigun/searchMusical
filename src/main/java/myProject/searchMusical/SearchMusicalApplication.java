package myProject.searchMusical;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SearchMusicalApplication {
	public static void main(String[] args) {
		SpringApplication.run(SearchMusicalApplication.class, args);
	}

	@Bean
	public ChromeDriver chromeDriver() {
		return new ChromeDriver();
	}
}