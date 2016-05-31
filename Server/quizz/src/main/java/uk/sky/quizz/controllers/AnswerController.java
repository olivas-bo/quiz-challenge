package uk.sky.quizz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.sky.quizz.domain.*;
import uk.sky.quizz.repositories.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/answer")
public class AnswerController {

	private final AnswerRepository answerRepository;
	private final PlayerRepository playerRepository;


	@Autowired
	public AnswerController(PlayerRepository playerRepository, AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
		this.playerRepository = playerRepository;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/{answerId}/player/{playerId}")
	public String answer(@PathVariable int answerId, @PathVariable int playerId) {

		Answer answer = answerRepository.findOne(answerId);
		Player player = playerRepository.findOne(playerId);
		
		player.getAnswerCollection().add(answer);
		answer.getPlayerCollection().add(player);

		answerRepository.save(answer);
		playerRepository.save(player);

		return "";
	}
}