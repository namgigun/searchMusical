package myProject.searchMusical.repository;

import myProject.searchMusical.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
