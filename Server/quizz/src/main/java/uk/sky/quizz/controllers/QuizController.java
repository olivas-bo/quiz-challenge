package uk.sky.quizz.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.sky.quizz.domain.Quiz;

@RestController
@RequestMapping("/show/{showId}/quiz")
public class QuizController {

	@RequestMapping(method = RequestMethod.GET)
	public Quiz getQuiz(@PathVariable int showId) {
		return null;
	}
}
