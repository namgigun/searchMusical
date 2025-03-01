package myProject.searchMusical;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class SearchMusicalApplication {
	public static void main(String[] args) {
		SpringApplication.run(SearchMusicalApplication.class, args);
	}

	@Bean
	public ChromeDriver chromeDriver() {
		return new ChromeDriver();
	}
}