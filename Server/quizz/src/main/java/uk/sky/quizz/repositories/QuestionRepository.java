package uk.sky.quizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.sky.quizz.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
