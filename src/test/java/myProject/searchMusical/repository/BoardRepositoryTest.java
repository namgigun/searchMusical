package myProject.searchMusical.repository;

import lombok.extern.log4j.Log4j2;
import myProject.searchMusical.domain.Board;
import myProject.searchMusical.service.BoardService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    WebDriver webDriver;

    @Autowired
    BoardService boardService;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .content("content.." + i)
                    .writer("user" + (i % 10))
                    .build();

            Board result = boardRepository.save(board);
            log.info("BNO: " + result.getId());
        });
    }

    @Test
    public void testDelete() {
        Long bno = 1L;
        boardRepository.deleteById(bno);
    }
}