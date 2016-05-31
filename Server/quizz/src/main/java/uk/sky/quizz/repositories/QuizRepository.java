package uk.sky.quizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.sky.quizz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	Quiz findOneByShowId(Integer showId);
}
