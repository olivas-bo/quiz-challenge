package uk.sky.quizz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import uk.sky.quizz.domain.Quiz;
import uk.sky.quizz.domain.Show;
import uk.sky.quizz.repositories.QuizRepository;
import uk.sky.quizz.repositories.ShowRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/show/{showId}/quiz")
public class QuizController {
	
	private final QuizRepository quizRepository;
	private final ShowRepository showRepository;

	@Autowired
	public QuizController(QuizRepository quizRepository, ShowRepository showRepository) {
		this.quizRepository = quizRepository;
		this.showRepository = showRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Quiz getQuiz(@PathVariable int showId) {
		System.out.println("Oh yeah baby.");
		Show show = showRepository.findOne(showId);
		return quizRepository.findOneByShowId(show);
	}
}