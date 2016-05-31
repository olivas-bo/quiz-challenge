package uk.sky.quizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.sky.quizz.domain.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
