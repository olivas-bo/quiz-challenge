package uk.sky.quizz.controllers;

import com.sun.tools.internal.ws.wsdl.document.http.HTTPConstants;
import com.sun.tools.internal.ws.wsdl.document.http.HTTPOperation;
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

	@RequestMapping(method = RequestMethod.GET, path = "/{answerId}/player/{playerId}")
	public String answer(@PathVariable int answerId, @PathVariable int playerId) {

		Answer answer = answerRepository.findOne(answerId);
		Player player = playerRepository.findOne(playerId);

	}
}