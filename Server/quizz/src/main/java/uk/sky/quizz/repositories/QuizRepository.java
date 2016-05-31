package uk.sky.quizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.sky.quizz.domain.Quiz;
import uk.sky.quizz.domain.Show;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	Quiz findOneByShowId(Show show);
}
