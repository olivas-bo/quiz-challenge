package uk.sky.quizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.sky.quizz.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
